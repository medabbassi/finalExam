package com.example.finalexam.controllers;

import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import com.example.finalexam.services.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PostMapping("/students/{id}/reservations")
    public ResponseEntity<Student> assignStudentToBook(@PathVariable("id") final Long studentId,
                                                       @RequestParam("isbn") final Long isbn) {
        Student student = studentService.assignStudentToBook(studentId, isbn);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> retrieveStudentByStatus(@RequestParam Status status) {
        List<Student> listOfStudent = studentService.retrieveStudentsByStatus(status);
        return ResponseEntity.ok(listOfStudent);
    }

//    @GetMapping("/students")
//    public ResponseEntity<List<Student>> retrieveStudentByAuthorName(@RequestParam String firstname,
//                                                                     @RequestParam String lastname) {
//        List<Student> listOfStudent = studentService.retrieveStudentsByAuthorName(firstname, lastname);
//        return ResponseEntity.ok(listOfStudent);
//    }

}