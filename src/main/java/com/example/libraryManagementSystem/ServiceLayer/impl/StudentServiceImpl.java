package com.example.libraryManagementSystem.ServiceLayer.impl;

import com.example.libraryManagementSystem.DTO.RequestDTO.AddStudentRequestDTO;
import com.example.libraryManagementSystem.DTO.RequestDTO.UpdateStudentMobileNoRequestDTO;
import com.example.libraryManagementSystem.DTO.ResponseDto.UpdateStudentMobileNoResponseDTO;
import com.example.libraryManagementSystem.Entity.Card;
import com.example.libraryManagementSystem.Entity.Student;
import com.example.libraryManagementSystem.Exception.StudentNotExistException;
import com.example.libraryManagementSystem.Repositorylayers.StudentRepository;
import com.example.libraryManagementSystem.ServiceLayer.StudentService;
import com.example.libraryManagementSystem.enums.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(AddStudentRequestDTO addStudentRequestDTO) {

        Student student = new Student();
        student.setName(addStudentRequestDTO.getName());
        student.setAge(addStudentRequestDTO.getAge());
        student.setDepertment(addStudentRequestDTO.getDepartment());
        student.setMobNo(addStudentRequestDTO.getMobile());

        Card card = new Card();
        card.setCardstatus(CardStatus.ACTIVATED);
        card.setValidDate("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student added";
    }

    public String deleteById(Integer id){
        studentRepository.deleteById(id);
        return "Student deleted";
    }

    @Override
    public Student getById(Integer id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public UpdateStudentMobileNoResponseDTO updateMobileNo(UpdateStudentMobileNoRequestDTO updateStudentMobileNoRequestDTO) throws StudentNotExistException {

        try{
            Student student = studentRepository.findById(updateStudentMobileNoRequestDTO.getId()).get();
            student.setMobNo(updateStudentMobileNoRequestDTO.getMobile());

            UpdateStudentMobileNoResponseDTO updateStudentMobileNoResponseDTO = new UpdateStudentMobileNoResponseDTO();
            updateStudentMobileNoResponseDTO.setName(student.getName());
            updateStudentMobileNoResponseDTO.setMobile(student.getMobNo());
            studentRepository.save(student);
            return updateStudentMobileNoResponseDTO;
        }
        catch (Exception e){
            throw new StudentNotExistException("Student does not exist");
        }




    }
}
