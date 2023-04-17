package com.example.libraryManagementSystem.Controllers;

import com.example.libraryManagementSystem.Entity.Author;
import com.example.libraryManagementSystem.ServiceLayer.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);
    }
    @DeleteMapping("/delete-by-id")
    public String deleteById(@RequestParam("id")Integer id){
        return authorService.deleteById(id);
    }

    @GetMapping("/get-by-id")
    public Author getById(@RequestParam("id")Integer id){
        return authorService.getById(id);
    }

    @GetMapping("/get-all")
    public List<Author> getAll(){
        return authorService.getAll();
    }
}
