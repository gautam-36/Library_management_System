package com.example.library_management_system.service.impl;

import com.example.library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.library_management_system.DTO.RequestDto.UpdateMobileRequestDto;
import com.example.library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.library_management_system.entity.Card;
import com.example.library_management_system.entity.Student;
import com.example.library_management_system.enums.CardStatus;
import com.example.library_management_system.exceptions.StudentNotFoundException;
import com.example.library_management_system.repository.StudentRepository;
import com.example.library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

// without using DTOs
//        // generate a new card for the student
//        Card card = new Card();
//        card.setCardStatus(CardStatus.ACTIVATED);
//        card.setValidTill("2024-01-01");
//        card.setStudent(student);
//
//        // set card for the student
//        student.setCard(card);
//        studentRepository.save(student);
//        return "Student added";

   Student student = new Student();
   student.setName(studentRequestDto.getName());
   student.setEmail(studentRequestDto.getEmail());
   student.setAge(studentRequestDto.getAge());
   student.setPhone(studentRequestDto.getPhone());
   student.setDepartment(studentRequestDto.getDepartment());

   Card card = new Card();
   card.setCardStatus(CardStatus.ACTIVATED);
   card.setValidTill("2024-09-01");
   card.setStudent(student);
   student.setCard(card);
   studentRepository.save(student);
   return "Student added successfully";

    }

    @Override
    public UpdateStudentMobNoResponseDto updatePhone(UpdateMobileRequestDto updateMobileRequestDto) {
        Student student ;
        try{
            student = studentRepository.findById(updateMobileRequestDto.getId()).get();
            student.setPhone(updateMobileRequestDto.getPhone());
            Student updatedStudent = studentRepository.save(student);

            // creating response Dto
            UpdateStudentMobNoResponseDto responseDto = new UpdateStudentMobNoResponseDto();
            responseDto.setPhone(updatedStudent.getPhone());
            responseDto.setName(updatedStudent.getName());
            return responseDto;
        }
        catch (Exception e){
            try {
                throw new StudentNotFoundException("Invalid student id");
            } catch (StudentNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}


//public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
//
//    try{
//        Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
//        student.setMobNo(updateStudentMobRequestDto.getMobNo());
//        Student updatedStudent = studentRepository.save(student);
//
//        // prepare response dto
//        UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
//        updateStudentMobNoResponseDto.setName(updatedStudent.getName());
//        updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
//        return updateStudentMobNoResponseDto;
//    }
//    catch (Exception e){
//        throw new StudentNotFoundException("Invalid student id");
//    }
//}
