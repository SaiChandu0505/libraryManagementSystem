package com.example.libraryManagementSystem.ServiceLayer.impl;

import com.example.libraryManagementSystem.Entity.Author;
import com.example.libraryManagementSystem.Repositorylayers.AuthorRepository;
import com.example.libraryManagementSystem.ServiceLayer.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added";
    }
    @Override
    public String deleteById(Integer id) {
        authorRepository.deleteById(id);
        return "Author Deleted";
    }

    @Override
    public Author getById(Integer id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
