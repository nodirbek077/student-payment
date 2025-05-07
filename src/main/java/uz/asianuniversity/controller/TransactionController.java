package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.service.TransactionService;

@RestController
@RequiredArgsConstructor
@Tag(name = "Student")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/api/students/{studentId}/transactions")
    public HttpEntity<?> createTransaction(@RequestParam(value = "studentId") Integer studentId, @RequestBody Transaction transaction){
        Transaction createdTransaction = transactionService.createTransaction(studentId, transaction);
        return ResponseEntity.status(201).body(createdTransaction);
    }
}
