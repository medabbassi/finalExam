package com.example.finalexam.repositories;

import com.example.finalexam.entities.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationRepo extends CrudRepository<Reservation, Long> {
}
