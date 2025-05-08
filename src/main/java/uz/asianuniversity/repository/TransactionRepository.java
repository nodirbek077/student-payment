package uz.asianuniversity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.payload.response.SummaryReportResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByStudentId(Integer studentId);

    @Query("SELECT " +
            "    new uz.asianuniversity.payload.response.SummaryReportResponseDto(COUNT(t), COALESCE(SUM(t.amount), 0.0)) " +
            "FROM Transaction t WHERE t.date BETWEEN :from AND :to")
    SummaryReportResponseDto getSummaryReport(@Param("from") LocalDate from, @Param("to") LocalDate to);

    Page<Transaction> findAll(Specification<Transaction> transactionSpecification, Pageable pageable);
}
