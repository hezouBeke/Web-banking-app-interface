package backend.example.Backend.service;

import backend.example.Backend.model.Acount;
import backend.example.Backend.model.Transaction;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AcountService {

    Acount creer(Long client_id,Acount acount);
    List<Acount> lire();
    Acount modifier(Long id,Acount acount);
    String supprimer(Long id);
    Acount getAcountById(Long id);
    Optional<Acount> getAcountByNumeroCompte(String numeroCompte);
    void faireVersement(Long acountId, double montant);
    void faireRetrait(Long acountId, double montant);
    void verser(Long acountIdSource, Long acountIdDestinataire, double montant);
    List<Acount> getAcountsByClientId(Long clientId);

    List<Transaction> getTransactionsByAcountAndPeriod(Long acountId, Date debut, Date fin);
}



