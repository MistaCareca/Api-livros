package dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookDTO(
    Long id,
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title must not exceed 100")
    String title,

    @NotBlank(message = "Author is mandatory")
    @Size(max = 50, message = "Author must not exceed 50")
    String author,

    @NotBlank(message = "ISBN is mandatory")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 character")
    String isbn,

    @Min(value = 0, message = "Publication year must be positive")
    Integer publicationYear,
    Boolean available,

    @Size(max = 50, message = "Category must not exceed 50 characters")
    String category
) {

}
