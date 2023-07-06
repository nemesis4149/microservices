package com.esprit.reservations.exception;


public class ReservationNotFoundException extends Throwable {
    public ReservationNotFoundException(String id) {
        super("Cannot found reservation number [" + id + "]");
    }
}
