package com.example.finalexam.services.impl;

import com.example.finalexam.entities.Author;
import com.example.finalexam.repositories.AuthorRepository;
import com.example.finalexam.services.IAuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository authorRepo;

    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }
}
