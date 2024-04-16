package com.example.finalexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    private String title;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnoreProperties(value = {"books", "authorID"})
    @ManyToOne
    @JoinColumn(name = "author_id") // name of the column in the book table
    private Author author;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}