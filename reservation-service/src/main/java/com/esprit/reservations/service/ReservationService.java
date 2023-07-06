package com.esprit.reservations.service;

import com.esprit.reservations.exception.ReservationNotFoundException;
import com.esprit.reservations.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ReservationService {
     List<Reservation> getAllReservations();
     Optional<Reservation> getReservationById(String id);
     Reservation createReservation(Reservation reservation);
     Reservation updateReservation(Reservation reservation, String id) throws ReservationNotFoundException;
     void deleteReservation(String id);
}
