package uz.asianuniversity.commons;

import lombok.Data;

@Data
public class GeneralResponse {
    private Integer errorCode;
    private String errorMessage;

    public GeneralResponse(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
