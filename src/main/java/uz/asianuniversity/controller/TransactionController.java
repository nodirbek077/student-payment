package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.asianuniversity.payload.request.TransactionRequest;
import uz.asianuniversity.payload.response.TransactionResponse;
import uz.asianuniversity.service.TransactionService;

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
}
