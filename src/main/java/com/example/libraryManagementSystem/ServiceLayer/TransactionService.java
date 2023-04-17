package com.example.libraryManagementSystem.ServiceLayer;


import com.example.libraryManagementSystem.DTO.RequestDTO.IssueBookRequestDto;
import com.example.libraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
