package com.example.library_management_system.service;

import com.example.library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_management_system.DTO.RequestDto.UpdateMobileRequestDto;
import com.example.library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_management_system.entity.Student;
import com.example.library_management_system.exceptions.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);
    public UpdateStudentMobNoResponseDto updatePhone(UpdateMobileRequestDto updateMobileRequestDto) throws StudentNotFoundException;
}