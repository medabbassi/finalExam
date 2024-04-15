package com.example.finalexam.services;

import com.example.finalexam.entities.Author;
import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.Reservation;
import com.example.finalexam.entities.Student;
import com.example.finalexam.repositories.AuthorRepo;
import com.example.finalexam.repositories.BookRepo;
import com.example.finalexam.repositories.ReservationRepo;
import com.example.finalexam.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IBookServiceImpl implements IBookService {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final StudentRepo studentRepo;
    private final ReservationRepo reservationRepo;

    public IBookServiceImpl(BookRepo bookRepo, AuthorRepo authorRepo, StudentRepo studentRepo, ReservationRepo reservationRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.studentRepo = studentRepo;
        this.reservationRepo = reservationRepo;
    }

    @Override
    public Book addBookAndAssignToAuthor(Book book, long authorID) {
        Optional<Author> author = authorRepo.findById(authorID);
        if (author.isPresent()){
            Author author1 = author.get();
            book.setAuthor(author1);
        }
        return bookRepo.save(book);
    }

    @Override
    public Student assignStudentToBook(Long studentId, Long isbn) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Book> optionalBook = bookRepo.findById(isbn);

        if (optionalStudent.isPresent() && optionalBook.isPresent()) {
            Student student = optionalStudent.get();
            Book book = optionalBook.get();
            Reservation reservation = new Reservation();
            reservation.setBook(book);
            reservation.setStudent(student);
             reservationRepo.save(reservation);
             return student;
        } else {
            throw new IllegalArgumentException("Not found");
        }
    }
}
