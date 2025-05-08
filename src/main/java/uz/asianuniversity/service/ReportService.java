package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.payload.response.SummaryReportResponseDto;
import uz.asianuniversity.repository.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByStudentId(Integer studentId){
        return transactionRepository.findByStudentId(studentId);
    }

    public SummaryReportResponseDto getSummaryReport(LocalDate from, LocalDate to){
        return transactionRepository.getSummaryReport(from, to);
    }
}
