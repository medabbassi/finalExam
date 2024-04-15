package com.example.finalexam.services;

import com.example.finalexam.entities.Author;
import com.example.finalexam.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IAuthorImpl implements IAuthorService {
    private final AuthorRepo authorRepo;

    public IAuthorImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author AddAuthor(Author author) {
        return authorRepo.save(author);
    }
}
