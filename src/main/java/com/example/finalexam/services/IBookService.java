package com.example.finalexam.services;

import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.Student;

public interface IBookService  {
    public Book addBookAndAssignToAuthor(Book book, long authorID);
    public Student assignStudentToBook(Long studentId, Long ISBN);
}
