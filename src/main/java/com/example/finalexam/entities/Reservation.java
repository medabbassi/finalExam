package com.example.finalexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationID", nullable = false)
    private Long reservatioID;

    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "studentID") // name of the column in the reservation table
    private Student student;

    @JsonIgnoreProperties(value = {"reservations","author"})
    @ManyToOne
    @JoinColumn(name = "isbn") // name of the column in the reservation table
    private Book book;

    public Long getReservatioID() {
        return reservatioID;
    }

    public void setReservatioID(Long reservatioID) {
        this.reservatioID = reservatioID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}