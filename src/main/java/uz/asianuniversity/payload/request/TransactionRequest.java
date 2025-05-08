package uz.asianuniversity.payload.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionRequest {

    private BigDecimal amount;

    private Date date;

    private String comment;
}
