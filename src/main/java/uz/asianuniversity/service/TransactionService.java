package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.repository.StudentRepository;
import uz.asianuniversity.repository.TransactionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final StudentRepository studentRepository;

    public Transaction createTransaction(Integer studentId, Transaction transaction){
        Optional<Student> checkStudent = studentRepository.findById(studentId);
        if(!checkStudent.isPresent()){
            return new Transaction();
        }

        Transaction newTransaction = new Transaction();
        Student student = checkStudent.get();
        newTransaction.setStudent(student);
        newTransaction.setAmount(transaction.getAmount());
        newTransaction.setDate(transaction.getDate());
        newTransaction.setComment(transaction.getComment());

        return transactionRepository.save(newTransaction);
    }
}
