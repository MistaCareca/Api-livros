package dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import model.Book;
import model.User;
import java.time.LocalDateTime;

public record ReviewDTO(
    Long id,

    @NotNull(message = "User Id is mandatory")
    User userId,

    @NotNull(message = "Book Id is mandatory")
    Book bookId,

    @Min(value = 0, message = "Rating must be at last 0")
    @Max(value = 5, message = "Rating cannot exceed 5")
    Integer rating,

    @Size(max = 500, message = "Comment must not exceed 500 characters")
    String commnet,
    LocalDateTime createdAt
) {
}
