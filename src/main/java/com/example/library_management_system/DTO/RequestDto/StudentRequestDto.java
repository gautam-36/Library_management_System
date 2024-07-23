package com.example.library_management_system.DTO.RequestDto;

import com.example.library_management_system.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentRequestDto {

    private String name;
    private int age;
    private Department department;
    private String email;
    private String phone;
}
