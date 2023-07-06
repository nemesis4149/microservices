package com.esprit.reservations.service;

import com.esprit.reservations.exception.ReservationNotFoundException;
import com.esprit.reservations.repository.ReservationRepository;
import com.esprit.reservations.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservationDto, String id) throws ReservationNotFoundException {
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return this.reservationRepository.save(reservationDto);
        } else {
            throw new ReservationNotFoundException(id);
        }
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
