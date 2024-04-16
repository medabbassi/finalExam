package com.example.finalexam.services.impl;

import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.LibraryCard;
import com.example.finalexam.entities.Reservation;
import com.example.finalexam.entities.Student;
import com.example.finalexam.entities.enumeration.Status;
import com.example.finalexam.repositories.BookRepository;
import com.example.finalexam.repositories.StudentRepository;
import com.example.finalexam.services.IStudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;


    public StudentServiceImpl(StudentRepository studentRepository, BookRepository bookRepository) {
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Student addStudent(Student student) {
        LibraryCard card = new LibraryCard();
        card.setStartDate(LocalDate.now());
        card.setStatus(Status.ACTIVE);
        student.setLibraryCard(card);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> retrieveStudentsByStatus(Status status) {
        return  studentRepository.findStudentsWithActiveCard(status);
    }

    @Override
    public List<Student> retrieveStudentsByAuthorName(String firstname, String lastname) {
        return null;
    }

    @Override
    public Student assignStudentToBook(Long studentId, Long isbn) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Book> optionalBook = bookRepository.findById(isbn);

        if (optionalStudent.isPresent() && optionalBook.isPresent()) {
            Student student = optionalStudent.get();
            Book book = optionalBook.get();
            Reservation reservation = new Reservation();
            reservation.setBook(book);
            reservation.setStudent(student);
            student.getReservations().add(reservation);
            studentRepository.save(student);
            return student;
        } else {
            throw new IllegalArgumentException("Not found");
        }
    }

}
