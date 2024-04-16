package com.example.finalexam.controllers;

import com.example.finalexam.entities.Book;
import com.example.finalexam.repositories.AuthorRepository;
import com.example.finalexam.services.IBookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    private final IBookService bookService;
    private final AuthorRepository authorRepository;

    public BookController(IBookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @PostMapping("/books")
    public Book addBookAndAssignToAuthor(@RequestBody Book book,
                                         @RequestParam("authorId") final Long authorId) {
        if (!authorRepository.existsById(authorId)) {
            throw new IllegalArgumentException("Author not found");
        }
        return bookService.addBookAndAssignToAuthor(book, authorId);
    }

}