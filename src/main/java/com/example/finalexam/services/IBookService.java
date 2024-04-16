package com.example.finalexam.services;

import com.example.finalexam.entities.Book;
import com.example.finalexam.entities.Student;

public interface IBookService  {
    Book addBookAndAssignToAuthor(Book book, long authorID);
}
