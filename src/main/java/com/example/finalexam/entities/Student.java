package com.example.finalexam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private  String lastName;

    @JsonIgnoreProperties(value = {"student"})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private LibraryCard libraryCard;

    @JsonIgnoreProperties(value = {"student"})
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentID) {
        this.studentId = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}