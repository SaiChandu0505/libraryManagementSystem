package com.example.libraryManagementSystem.ServiceLayer;

import com.example.libraryManagementSystem.Entity.Author;

import java.util.List;

public interface AuthorService {

    public String addAuthor(Author author);

    String deleteById(Integer id);

    Author getById(Integer id);

    List<Author> getAll();
}
