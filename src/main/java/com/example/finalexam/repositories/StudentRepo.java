package com.example.finalexam.repositories;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo  extends CrudRepository<Student, Long> {
}
