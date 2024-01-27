package backend.example.Backend.service;

import backend.example.Backend.model.Acount;
import backend.example.Backend.model.Transaction;
import backend.example.Backend.repository.TransactionRepository;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByAcountAndPeriod(Long acountId, Date debut, Date fin);
    void effectuerVirement(Acount compteSource, Acount compteDestinataire, double montant);
    Transaction enregistrerTransaction(Acount compteSource, double montant, String description);

}

