package com.example.finalexam.repositories;

import com.example.finalexam.entities.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
