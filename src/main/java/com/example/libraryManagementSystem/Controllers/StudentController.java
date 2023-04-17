package com.example.libraryManagementSystem.Controllers;


import com.example.libraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.libraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.libraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.libraryManagementSystem.Entity.Student;
import com.example.libraryManagementSystem.Exception.StudentNotExistException;
import com.example.libraryManagementSystem.ServiceLayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody AddStudentRequestDTO addStudentRequestDTO){
        return studentService.addStudent(addStudentRequestDTO);
    }
    @DeleteMapping("/delete-by-id")
    public String deleteById(@RequestParam("id")Integer id){return studentService.deleteById(id); }

    @GetMapping("/get-by-id")
    public Student geById(@RequestParam("id")Integer id){
        return studentService.getById(id);
    }

    @GetMapping("/get-all")
    public List<Student> getAllStudent(){ return studentService.getAllStudent(); }

    @GetMapping("/update-mobileNo")
    public UpdateStudentMobileNoResponseDTO updateMobileNo(@RequestBody UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException {
        return studentService.updateMobileNo(updateStudentMobileNoRequestDTO);
    }
}
