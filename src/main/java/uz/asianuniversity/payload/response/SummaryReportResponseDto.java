package uz.asianuniversity.payload.response;

import lombok.Data;

@Data
public class SummaryReportResponseDto {
    private Long totalTransactions;
    private Integer totalAmount;

    public SummaryReportResponseDto(Long totalTransactions, Integer totalAmount) {
        this.totalTransactions = totalTransactions;
        this.totalAmount = totalAmount;
    }
}
