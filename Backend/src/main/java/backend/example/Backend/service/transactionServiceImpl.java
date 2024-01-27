package backend.example.Backend.service;

import backend.example.Backend.model.Acount;
import backend.example.Backend.model.Transaction;
import backend.example.Backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class transactionServiceImpl implements  TransactionService{

    private final TransactionRepository transactionRepository;
    private final Clock clock;



    public transactionServiceImpl(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByAcountAndPeriod(Long acountId, Date debut, Date fin) {
        return transactionRepository.findByAcount_IdAndDateTransactionBetween(acountId, debut, fin);
    }

    @Override
    public void effectuerVirement(Acount compteSource, Acount compteDestinataire, double montant) {
        enregistrerTransaction(compteSource, montant, "Virement sortant");
        enregistrerTransaction(compteDestinataire, montant, "Virement entrant");
    }



    @Override
    public Transaction enregistrerTransaction(Acount compteSource, double montant, String description) {
        Transaction transaction = new Transaction();
        transaction.setAcount(compteSource);
        transaction.setMontant(montant);
        transaction.setDateTransaction(LocalDateTime.now(clock));
        transaction.setDescription(description);

        transaction = transactionRepository.save(transaction);
        compteSource.getTransactions().add(transaction);

        // Mettez à jour le solde du compte source ici si nécessaire

        return transaction;
    }
}
