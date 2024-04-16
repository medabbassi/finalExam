package com.example.finalexam.services.impl;

import com.example.finalexam.entities.Author;
import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.Reservation;
import com.example.finalexam.entities.Student;
import com.example.finalexam.repositories.AuthorRepository;
import com.example.finalexam.repositories.BookRepository;
import com.example.finalexam.repositories.ReservationRepository;
import com.example.finalexam.repositories.StudentRepository;
import com.example.finalexam.services.IBookService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImpl implements IBookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepo;
    private final StudentRepository studentRepository;
    private final ReservationRepository reservationRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepo, StudentRepository studentRepository, ReservationRepository reservationRepository) {
        this.bookRepository = bookRepository;
        this.authorRepo = authorRepo;
        this.studentRepository = studentRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Book addBookAndAssignToAuthor(Book book, long authorID) {
        Optional<Author> author = authorRepo.findById(authorID);
        if (author.isPresent()) {
            book.setAuthor(author.get());
        }
        return bookRepository.save(book);
    }

}
