package com.example.finalexam.controllers;

import com.example.finalexam.entities.Author;
import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.LibraryCard;
import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import com.example.finalexam.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/controller")
public class FinalExamController  {

    IAuthorService authorService;
    IStudentService studentService;
    IBookService iBookService;

    @Autowired
    public FinalExamController(IAuthorService authorService, IStudentService studentService, IBookService iBookService) {
        this.authorService = authorService;
        this.studentService = studentService;
        this.iBookService = iBookService;
    }

    @PostMapping("/addAssignedBookAuthor")
    public Book addBookAndAssignToAuthor(@RequestBody Book book, @RequestParam("authorid") Long authorId){
            return iBookService.addBookAndAssignToAuthor(book, authorId);
    }


    @PostMapping("/addAssignedBookStudent")
    public Student assignStudentToBook(@RequestParam("studentid") Long studentId, @RequestParam("isbn") Long ISBN) {
        return iBookService.assignStudentToBook(studentId, ISBN);
    }



    @PostMapping("/addAuthor")
    public Author AddAuthor(@RequestBody Map<String, String> request){
        Author author =new Author();
        author.setFirstName(request.get("firstName"));
        author.setLastName(request.get("lastName"));
        return  authorService.AddAuthor(author);

    }
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Map<String, Object> requestData) {
        try {
            String firstName = (String) requestData.get("firstName");
            String lastName = (String) requestData.get("lastName");

            Map<String, Object> libraryCardData = (Map<String, Object>) requestData.get("libraryCard");
            String status = (String) libraryCardData.get("status");
            String startDate = (String) libraryCardData.get("startDate"); // Assuming date is a string in format YYYY-MM-DD
            System.out.println(startDate);
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDates = LocalDate.parse(startDate, dateFormatter);

            LibraryCard libraryCard = new LibraryCard();
            libraryCard.setStatus(Status.ACTIVE);
            libraryCard.setStartDate(startDates);

            libraryCard.setStudent(student);
            student.setLibraryCard(libraryCard);

            studentService.addStudent(student);

            return ResponseEntity.ok("Student added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: t " + e.getMessage());
        }
    }

    @GetMapping("/getStudentByStatus")
    public ResponseEntity<List<Student>> retriveStudentByStatus( @RequestParam Status status) {
        List<Student> listOfStudent = studentService.retrieveStudentByStatus(status);
        return ResponseEntity.ok(listOfStudent);
    }

}
