package com.esprit.serveurs.exception;


public class ServeurNotFoundException extends Throwable {
    public ServeurNotFoundException(String id) {
        super("serveur introuvable [" + id + "]");
    }
}
