package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.exception.ResourceNotFoundException;
import uz.asianuniversity.payload.request.TransactionRequest;
import uz.asianuniversity.payload.response.TransactionResponse;
import uz.asianuniversity.repository.StudentRepository;
import uz.asianuniversity.repository.TransactionRepository;

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
}
