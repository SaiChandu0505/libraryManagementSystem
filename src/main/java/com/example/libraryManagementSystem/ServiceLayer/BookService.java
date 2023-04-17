package com.example.libraryManagementSystem.ServiceLayer;

import com.example.libraryManagementSystem.Entity.Author;
import com.example.libraryManagementSystem.Entity.Book;

import java.util.List;

public interface BookService {

    public String addBook(Book book) throws Exception;


    Integer noOfBooksWrittenByAuthor(Author author);

    List<Book> findAllTheBooks();

    List<Book> findAllBooksOfAuthor(Author author) throws Exception;
}
