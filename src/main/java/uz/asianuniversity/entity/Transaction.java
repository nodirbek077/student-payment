package uz.asianuniversity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //transaction id

    private BigDecimal amount; //payment amount

    private Date date; //payment date

    private String comment; //client comment

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;  // connecting to the student
}
