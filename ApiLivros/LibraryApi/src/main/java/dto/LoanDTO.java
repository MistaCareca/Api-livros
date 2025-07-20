package dto;

import jakarta.validation.constraints.NotNull;
import model.Book;
import model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanDTO(
    Long id,

    @NotNull(message = "User Id is mandatory")
    User userId,

    @NotNull(message = "Book Id is mandatory")
    Book bookId,

    @NotNull(message = "Loan Date Id is mandatory")
    LocalDateTime loanDate,

    @NotNull(message = "Due Date Id is mandatory")
    LocalDateTime dueDate,

    LocalDateTime returnDate,
    BigDecimal fine
) {
}
