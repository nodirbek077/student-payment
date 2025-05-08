package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.asianuniversity.entity.Transaction;
import uz.asianuniversity.payload.response.SummaryReportResponseDto;
import uz.asianuniversity.service.ReportService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Report", description = "Transaction reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/api/students/{studentId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByStudentId(@PathVariable Integer studentId) {
        List<Transaction> transactions = reportService.getTransactionsByStudentId(studentId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/api/reports/summary")
    public ResponseEntity<?> getSummaryReport(@RequestParam("from") LocalDate from,
                                              @RequestParam("to") LocalDate to){
        SummaryReportResponseDto summaryReport = reportService.getSummaryReport(from, to);
        return ResponseEntity.ok(summaryReport);
    }
}
