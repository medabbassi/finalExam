package com.example.finalexam.services;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import com.example.finalexam.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IStudentImpl  implements IStudentService{
    private final StudentRepo  studentRepo;

    public IStudentImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> retrieveStudentByStatus(Status status) {
        return (List<Student>) studentRepo.findAll();
    }
}
