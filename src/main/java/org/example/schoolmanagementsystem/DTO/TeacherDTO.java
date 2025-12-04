package org.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.schoolmanagementsystem.Model.Address;

@Data
@AllArgsConstructor
public class TeacherDTO
{
    @NotEmpty(message = "name is required")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "name shouldn't contain numbers and symbols")
    private String name;
    @NotNull(message = "age is required")
    @Min(value = 21, message = "teacher's age shouldn't be less than 21")
    @Max(value = 65, message = "teacher's age shouldn't be more than 65")
    private Integer age;
    @Email
    @NotEmpty(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9.-_]+@(gmail\\.com|outlook\\.com|hotmail\\.com|yahoo\\.com)$",message = "Email must be a valid Gmail, Outlook, hotmail, or yahoo address")
    private String email;
    @NotNull(message = "salary is required")
    private Integer salary;

    private Address address;
}
