package org.example.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is required")
    @Column(columnDefinition = "varchar(30) not null")
    @Pattern(regexp = "^[a-zA-Z ]+$",message = "name shouldn't contain numbers and symbols")
    private String name;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "age is required")
    @Min(value = 21, message = "teacher's age shouldn't be less than 21")
    @Max(value = 65, message = "teacher's age shouldn't be more than 65")
    private Integer age;
    @Email
    @NotEmpty(message = "email is required")
    @Column(columnDefinition = "varchar(35) not null")
    @Pattern(regexp = "^[a-zA-Z0-9.-_]+@(gmail\\.com|outlook\\.com|hotmail\\.com|yahoo\\.com)$",message = "Email must be a valid Gmail, Outlook, hotmail, or yahoo address")
    private String email;
    @NotNull(message = "salary is required")
    private Integer salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
}
