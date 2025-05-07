package uz.asianuniversity.payload.response;

import lombok.Getter;
import lombok.Setter;
import uz.asianuniversity.commons.GeneralResponse;

@Getter
@Setter
public class StudentResponse extends GeneralResponse {
    private Integer studentId;

    public StudentResponse(Integer studentId, String message, Integer code) {
        super(message, code);
        this.studentId = studentId;
    }
}
