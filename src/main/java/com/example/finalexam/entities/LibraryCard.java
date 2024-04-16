package com.example.finalexam.entities;

import com.example.finalexam.entities.enumeration.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "library_card")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long cardId;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDate startDate;

    @OneToOne(mappedBy = "libraryCard")
    private Student student;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}