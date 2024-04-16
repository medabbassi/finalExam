package com.example.finalexam.services;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);
    Student assignStudentToBook(Long studentId, Long isbn);
    List<Student> retrieveStudentsByStatus(Status status);
    List<Student> retrieveStudentsByAuthorName(String firstname, String lastname);
}
