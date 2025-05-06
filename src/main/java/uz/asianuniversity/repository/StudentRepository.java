package uz.asianuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.asianuniversity.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
