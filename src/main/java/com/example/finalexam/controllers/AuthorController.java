package com.example.finalexam.controllers;

import com.example.finalexam.entities.Author;
import com.example.finalexam.services.IAuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.addAuthor(author);
        return ResponseEntity.ok(savedAuthor);
    }
}