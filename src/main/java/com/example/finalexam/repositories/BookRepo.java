package com.example.finalexam.repositories;

import com.example.finalexam.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo  extends CrudRepository<Book, Long> {
}
