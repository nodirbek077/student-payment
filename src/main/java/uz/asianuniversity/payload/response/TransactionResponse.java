package uz.asianuniversity.payload.response;

import lombok.Getter;
import lombok.Setter;
import uz.asianuniversity.commons.GeneralResponse;

@Getter
@Setter
public class TransactionResponse extends GeneralResponse {
    private Long transactionId;

    public TransactionResponse(Integer errorCode, String errorMessage, Long transactionId) {
        super(errorCode, errorMessage);
        this.transactionId = transactionId;
    }
}
