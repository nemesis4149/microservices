package com.esprit.reservations.exception;


public class ServeurNotFoundException extends Throwable {
    public ServeurNotFoundException(String id) {
        super("serveur introuvable [" + id + "]");
    }
}
