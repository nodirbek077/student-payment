package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.exception.ResourceNotFoundException;
import uz.asianuniversity.helper.TransactionSpecification;
import uz.asianuniversity.payload.request.TransactionRequest;
import uz.asianuniversity.payload.response.TransactionResponse;
import uz.asianuniversity.repository.StudentRepository;
import uz.asianuniversity.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final StudentRepository studentRepository;

    public TransactionResponse createTransactionToStudent(Integer studentId, TransactionRequest transactionRequest){

        Optional<Student> checkStudent = Optional.ofNullable(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId)));

        Transaction newTransaction = new Transaction();

        newTransaction.setStudent(checkStudent.get());
        newTransaction.setAmount(transactionRequest.getAmount());
        newTransaction.setDate(transactionRequest.getDate());
        newTransaction.setComment(transactionRequest.getComment());
        Transaction savedTRansaction = transactionRepository.save(newTransaction);

        return new TransactionResponse(0, "Transaction created successfully", savedTRansaction.getId());
    }

    public Page<Transaction> getTransactions(LocalDate from, LocalDate to, BigDecimal minAmount, Pageable pageable) {
        return transactionRepository.findAll(TransactionSpecification.filterBy(from, to, minAmount), pageable);
    }

    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
    }

    public Transaction updateTransaction(Integer id, TransactionRequest transactionRequest) {

        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));

        existingTransaction.setDate(transactionRequest.getDate());
        existingTransaction.setAmount(transactionRequest.getAmount());
        existingTransaction.setComment(transactionRequest.getComment());

        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransaction(Integer id) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));

        transactionRepository.delete(existingTransaction);
    }





}
