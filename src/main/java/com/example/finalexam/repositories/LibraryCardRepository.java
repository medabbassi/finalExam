package com.example.finalexam.repositories;

import com.example.finalexam.entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibraryCardRepository extends CrudRepository<LibraryCard, Long> {
}