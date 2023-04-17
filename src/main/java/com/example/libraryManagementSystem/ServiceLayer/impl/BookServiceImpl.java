package com.example.libraryManagementSystem.ServiceLayer.impl;

import com.example.libraryManagementSystem.Entity.Author;
import com.example.libraryManagementSystem.Entity.Book;
import com.example.libraryManagementSystem.Repositorylayers.AuthorRepository;
import com.example.libraryManagementSystem.ServiceLayer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try {
             author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author Not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added ";
    }
    @Override
    public Integer noOfBooksWrittenByAuthor(Author author) {
        Author author1 = authorRepository.findById(author.getId()).get();
        return author1.getBooks().size();
    }

    @Override
    public List<Book> findAllTheBooks() {
        List<Author> authors = authorRepository.findAll();
        List<Book> allBooksList = new ArrayList<>();
        for(Author author : authors){
            List<Book> booksByAuthor = author.getBooks();
            for(int i=0; i<booksByAuthor.size(); i++){
                allBooksList.add(booksByAuthor.get(i));
            }
        }
        return allBooksList;
    }

    @Override
    public List<Book> findAllBooksOfAuthor(Author author) throws Exception {
        Author author1;
        try{
            author1 = authorRepository.findById(author.getId()).get();
        }
        catch(Exception e){
            throw new Exception("Author not present");
        }
        return author1.getBooks();
    }
}
