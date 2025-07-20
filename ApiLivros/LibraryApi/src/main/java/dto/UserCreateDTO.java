package dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateDTO(

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    String username,

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters")
    String password,

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    String email,

    @NotBlank(message = "Full Name is mandatory")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    String fullName
) {
}
