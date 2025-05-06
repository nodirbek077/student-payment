package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name = "Student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public HttpEntity<?> createStudent(Student student){
        return ResponseEntity.status(201).body(student);
    }

    @GetMapping()
    public HttpEntity<?> getAllStudents(Student student){
        return ResponseEntity.status(200).body(student);
    }

    @GetMapping()
    public HttpEntity<?> getStudentById(Student student){
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping()
    public HttpEntity<?> updateStudent(Student student){
        return ResponseEntity.status(200).body(student);
    }

    @DeleteMapping
    public HttpEntity<?> deleteStudent(Student student){
        return ResponseEntity.status(200).body(student);
    }
}
