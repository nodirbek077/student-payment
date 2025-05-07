package uz.asianuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.asianuniversity.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
