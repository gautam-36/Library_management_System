package com.example.library_management_system.controller;

import com.example.library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_management_system.DTO.RequestDto.UpdateMobileRequestDto;
import com.example.library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_management_system.entity.Student;
import com.example.library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }


    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updatePhone(@RequestBody UpdateMobileRequestDto updateMobileRequestDto)
    throws Exception{
        return studentService.updatePhone(updateMobileRequestDto);

    }

    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students
}