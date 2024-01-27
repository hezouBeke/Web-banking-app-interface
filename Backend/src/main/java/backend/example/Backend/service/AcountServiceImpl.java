package backend.example.Backend.service;

import backend.example.Backend.model.Acount;
import backend.example.Backend.model.Client;
import backend.example.Backend.model.Transaction;
import backend.example.Backend.repository.AcountRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service

public class AcountServiceImpl implements AcountService {
    private final AcountRepository acountRepository;
    private final TransactionService transactionService;
    private final ClientService clientService;

    public AcountServiceImpl(AcountRepository acountRepository, ClientService clientService,TransactionService transactionService) {
        this.acountRepository = acountRepository;
        this.clientService = clientService;
        this.transactionService=transactionService;
    }

    @Override
    public Acount creer(Long client_id,Acount acount) {
        ;
        Client client = clientService.getClientById(client_id);
        if (client != null) {
            acount.setClient(client);
            return acountRepository.save(acount);
        } else {

            return null;
        }
    }

    @Override
    public List<Acount> lire() {
        return acountRepository.findAll();
    }

    @Override
    public Acount modifier(Long id, Acount acount) {
        return acountRepository.findById(id)
                .map(ca->{
                    ca.setSolde(acount.getSolde());
                    ca.setNumeroCompte(acount.getNumeroCompte());
                    ca.setTypeCompte(acount.getTypeCompte());
                    ca.setClient(acount.getClient());
                    ca.setTransactions(acount.getTransactions());

                    return acountRepository.save(ca);

                }).orElseThrow(()->new RuntimeException("Compte non trouvé!"));
    }

    @Override
    public String supprimer(Long id) {
        acountRepository.deleteById(id);
        return "Compte supprimé avec succes!";
    }

    public Acount getAcountById(Long id) {
        return acountRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Acount> getAcountByNumeroCompte(String numeroCompte) {
        return acountRepository.findByNumeroCompte(numeroCompte);
    }

    @Override
    public void faireVersement(Long acountId, double montant) {
        Acount acount = acountRepository.findById(acountId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé avec l'ID : " + acountId));

        acount.deposer(montant);
        acountRepository.save(acount);

        transactionService.enregistrerTransaction(acount, montant, "Versement");


}

    @Override
    public List<Acount> getAcountsByClientId(Long clientId) {
        return acountRepository.findByClientId(clientId);
    }

    public void faireRetrait(Long acountId, double montant) {
        Acount acount = acountRepository.findById(acountId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé avec l'ID : " + acountId));

        if (acount.getSolde() >= montant) {
            acount.retirer(montant);
            acountRepository.save(acount);

            transactionService.enregistrerTransaction(acount, montant, "Retrait");
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le retrait.");
        }
    }

    @Override
    public void verser(Long acountIdSource, Long acountIdDestinataire, double montant) {
        Acount compteSource = acountRepository.findById(acountIdSource)
                .orElseThrow(() -> new RuntimeException("Compte source non trouvé avec l'ID : " + acountIdSource));
        Acount compteDestinataire = acountRepository.findById(acountIdDestinataire)
                .orElseThrow(() -> new RuntimeException("Compte destinataire non trouvé avec l'ID : " + acountIdDestinataire));

        if (compteSource.getSolde() >= montant) {
            compteSource.retirer(montant);
            compteDestinataire.deposer(montant);

            acountRepository.saveAll(List.of(compteSource, compteDestinataire));

            transactionService.enregistrerTransaction(compteSource, montant,"Virement sortant");
            transactionService.enregistrerTransaction(compteDestinataire, montant, "Virement entrant");
        } else {
            throw new RuntimeException("Solde insuffisant pour effectuer le virement.");
        }
    };
    @Override
    public List<Transaction> getTransactionsByAcountAndPeriod(Long acountId, Date debut, Date fin) {
        Acount acount = acountRepository.findById(acountId)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé avec l'ID : " + acountId));

        return transactionService.getTransactionsByAcountAndPeriod(acount.getId(), debut, fin);
    }
}

