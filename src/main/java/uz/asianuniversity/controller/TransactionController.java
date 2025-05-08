package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.payload.request.TransactionRequest;
import uz.asianuniversity.payload.response.TransactionResponse;
import uz.asianuniversity.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@Tag(name = "Transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/api/students/{studentId}/transactions")
    public ResponseEntity<?> createTransactionToStudent(@PathVariable Integer studentId,
                                                         @RequestBody TransactionRequest transactionRequest) {
        TransactionResponse createdTransactionToStudent = transactionService.createTransactionToStudent(studentId, transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransactionToStudent);
    }

    @GetMapping
    public ResponseEntity<Page<Transaction>> getTransactions(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to,
            @RequestParam(required = false) BigDecimal minAmount,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Transaction> transactions = transactionService.getTransactions(from, to, minAmount, pageable);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/api/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/api/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id,
                                                         @RequestBody TransactionRequest transactionRequest) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionRequest);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();  // 204 status code
    }
}
