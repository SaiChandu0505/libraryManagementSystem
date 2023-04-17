package com.example.libraryManagementSystem.Controllers;


import com.example.libraryManagementSystem.DTO.RequestDTO.IssueBookRequestDto;
import com.example.libraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.libraryManagementSystem.ServiceLayer.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        return transactionService.issueBook(issueBookRequestDto);
    }
}
