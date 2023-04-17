package com.example.libraryManagementSystem.Controllers;

import com.example.libraryManagementSystem.Entity.Author;
import com.example.libraryManagementSystem.Entity.Book;
import com.example.libraryManagementSystem.ServiceLayer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {

        return bookService.addBook(book);
    }
    @GetMapping("/no-of-books-written-by-author")
    public Integer noOfBooksWrittenByAuthor(@RequestBody Author author){
        return bookService.noOfBooksWrittenByAuthor(author);
    }

    @GetMapping("/find-all-the-books")
    public List<Book> findAllTheBook(){
        return bookService.findAllTheBooks();
    }

    @GetMapping("/find-all-books-of-author")
    public List<Book> findAllBooksOfAuthor(Author author) throws Exception {
        return bookService.findAllBooksOfAuthor(author);
    }
}
