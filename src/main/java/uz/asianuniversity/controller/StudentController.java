package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.asianuniversity.payload.request.StudentRequest;
import uz.asianuniversity.payload.response.StudentResponse;
import uz.asianuniversity.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name = "Student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public HttpEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse createdStudent = studentService.createStudent(studentRequest);
        return ResponseEntity.status(201).body(createdStudent);
    }
//
//    @GetMapping()
//    public HttpEntity<?> getAllStudents(Student student){
//        return ResponseEntity.status(200).body(student);
//    }
//
//    @GetMapping()
//    public HttpEntity<?> getStudentById(Student student){
//        return ResponseEntity.status(200).body(student);
//    }
//
//    @PutMapping()
//    public HttpEntity<?> updateStudent(Student student){
//        return ResponseEntity.status(200).body(student);
//    }
//
//    @DeleteMapping
//    public HttpEntity<?> deleteStudent(Student student){
//        return ResponseEntity.status(200).body(student);
//    }
}
