package com.masai.springRelationship3.SpringRelationship.controller;

import com.masai.springRelationship3.SpringRelationship.entity.Author;
import com.masai.springRelationship3.SpringRelationship.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/author")
    public String updateAuthor(@RequestBody Author author){
        return  authorService.updateAuthor(author);
    }

    @DeleteMapping("/author/{id}")
    public String deleteAuthor(@PathVariable("id") long authorId){
        boolean flag = authorService.deleteAuthor(authorId);
        if(flag) return "Author deleted";
        else return "unable to detect";
    }

}
