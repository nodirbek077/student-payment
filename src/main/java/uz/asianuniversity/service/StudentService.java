package uz.asianuniversity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.asianuniversity.entity.Student;
import uz.asianuniversity.exception.ResourceNotFoundException;
import uz.asianuniversity.payload.request.StudentRequest;
import uz.asianuniversity.payload.response.StudentResponse;
import uz.asianuniversity.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse createStudent(StudentRequest studentRequest){
        Student newStudent = new Student();
        Student savedStudent = studentCreateOrUpdateAction(studentRequest, newStudent);

        return new StudentResponse(0, "Student created successfully", savedStudent.getId());
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public StudentResponse updateStudent(Integer id, StudentRequest updatingStudentRequest) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        Student savedUpdatedStudent = studentCreateOrUpdateAction(updatingStudentRequest, existingStudent);
        return new StudentResponse(0, "Student updated successfully", savedUpdatedStudent.getId());
    }

    private Student studentCreateOrUpdateAction(StudentRequest updatingOrCreatingStudent, Student existingStudent) {
        existingStudent.setFirstname(updatingOrCreatingStudent.getFirstname());
        existingStudent.setLastname(updatingOrCreatingStudent.getLastname());
        existingStudent.setPhoneNumber(updatingOrCreatingStudent.getPhoneNumber());
        existingStudent.setCourseNumber(updatingOrCreatingStudent.getCourseNumber());
        existingStudent.setStudentGroup(updatingOrCreatingStudent.getStudentGroup());
        existingStudent.setSpecification(updatingOrCreatingStudent.getSpecification());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Integer id) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        studentRepository.delete(existing);  // Studentni o‘chirish
    }

}
