package com.example.libraryManagementSystem.ServiceLayer;

import com.example.libraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.libraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.libraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.libraryManagementSystem.Entity.Student;
import com.example.libraryManagementSystem.Exception.StudentNotExistException;

import java.util.List;


public interface StudentService {

    public String addStudent(AddStudentRequestDTO addStudentRequestDTO);
    public String deleteById(Integer id);

    public Student getById(Integer id);

    public List<Student> getAllStudent();

    UpdateStudentMobileNoResponseDTO updateMobileNo(UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException;
}
