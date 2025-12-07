package org.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is required")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "how old are you?")
    private Integer age;
    @NotEmpty(message = "major is required")
    @Column(columnDefinition = "varchar(15) not null")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
