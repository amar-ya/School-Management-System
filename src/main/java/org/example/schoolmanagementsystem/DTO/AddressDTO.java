package org.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO
{
    @NotNull(message = "teacher's id is required")
    private Integer teacher_id;
    @NotEmpty(message = "area is required")
    private String area;
    @NotEmpty(message = "street is required")
    private String street;
    @NotEmpty(message = "building number is required")
    private String building_number;
}
