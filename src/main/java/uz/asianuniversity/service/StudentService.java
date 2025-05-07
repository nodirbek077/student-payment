package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.payload.request.StudentRequest;
import uz.asianuniversity.payload.response.StudentResponse;
import uz.asianuniversity.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest studentRequest){
        Student newStudent = new Student();
        newStudent.setFirstname(studentRequest.getFirstname());
        newStudent.setLastname(studentRequest.getLastname());
        newStudent.setPhoneNumber(studentRequest.getPhoneNumber());
        newStudent.setCourseNumber(studentRequest.getCourseNumber());
        newStudent.setStudentGroup(studentRequest.getStudentGroup());
        newStudent.setSpecification(studentRequest.getSpecification());

        Student savedStudent = studentRepository.save(newStudent);

        return new StudentResponse(savedStudent.getId(), "Student created successfully", 0);
    }
}
