package com.example.finalexam.repositories;

import com.example.finalexam.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo   extends CrudRepository<Author , Long> {


}
