package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull
    @CreationTimestamp
    private LocalDateTime loanDate;

    @NotNull
    private LocalDateTime dueDate;

    private LocalDateTime returnDate;

    @DecimalMin(value = "0.0", message = "Fine cannot be negative")
    private BigDecimal fine;
}
