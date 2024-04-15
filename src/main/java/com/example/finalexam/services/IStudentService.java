package com.example.finalexam.services;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;

import java.util.List;

public interface IStudentService {
    public Student addStudent(Student student);
    public List<Student> retrieveStudentByStatus(Status status);
}
