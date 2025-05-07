package uz.asianuniversity.payload.request;

import lombok.Data;

@Data
public class StudentRequest {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String courseNumber;

    private String studentGroup;

    private String specification;
}
