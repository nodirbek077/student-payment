package uz.asianuniversity.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.payload.request.StudentRequest;
import uz.asianuniversity.payload.response.StudentResponse;
import uz.asianuniversity.service.StudentService;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(name = "Student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse createdStudent = studentService.createStudent(studentRequest);
        return ResponseEntity.status(201).body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getStudents(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "20") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Student> students = studentService.getStudents(pageable);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Integer id,
                                                         @RequestBody StudentRequest updatingStudent) {
        StudentResponse student = studentService.updateStudent(id, updatingStudent);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();  // 204 status code
    }
}
