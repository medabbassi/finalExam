package com.example.finalexam.repositories;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN s.libraryCard lb WHERE lb.status = :status")
    List<Student> findStudentsWithActiveCard(Status status);

}
