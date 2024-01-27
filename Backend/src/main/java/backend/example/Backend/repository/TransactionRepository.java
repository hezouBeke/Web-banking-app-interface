package backend.example.Backend.repository;

import backend.example.Backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAcount_IdAndDateTransactionBetween(Long acountId, Date debut, Date fin);

}
