package uz.asianuniversity.helper;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import uz.asianuniversity.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionSpecification {

    public static Specification<Transaction> filterBy(LocalDate from, LocalDate to, BigDecimal minAmount) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (from != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("date"), from));
            }

            if (to != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("date"), to));
            }

            if (minAmount != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("amount"), minAmount));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

