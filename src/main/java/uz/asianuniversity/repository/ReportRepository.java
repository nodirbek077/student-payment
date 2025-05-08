package uz.asianuniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.asianuniversity.entity.Student;

public interface ReportRepository extends JpaRepository<Student, Integer> {

}
