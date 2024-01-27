package backend.example.Backend.controller;

import backend.example.Backend.model.Transaction;
import backend.example.Backend.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{acount_id}/period")
    public List<Transaction> getTransactionsByAcountAndPeriod(@PathVariable Long acountId,
                                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date debut,
                                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
        return transactionService.getTransactionsByAcountAndPeriod(acountId, debut, fin);
    }

    // Ajoutez d'autres méthodes selon vos besoins, par exemple, pour enregistrer une nouvelle transaction, etc.

}
