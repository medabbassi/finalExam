package com.example.finalexam.services;

import com.example.finalexam.entities.Reservation;
import com.example.finalexam.repositories.ReservationRepo;
import org.springframework.stereotype.Service;

@Service
public class IReservationImpl implements IReservationService {

    private final ReservationRepo reservationRepo;

    public IReservationImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }


    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepo.save(reservation);
    }


}
