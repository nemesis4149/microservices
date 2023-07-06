package com.esprit.reservations.service;

import com.esprit.reservations.exception.ServeurNotFoundException;
import com.esprit.reservations.model.Serveur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ServeurService {
     List<Serveur> getAllServeurs();
     Optional<Serveur> getServeurById(String id);
     Serveur createServeur(Serveur serveur);
     Serveur updateServeur(Serveur serveur, String id) throws ServeurNotFoundException;
     void deleteServeur(String id);
}
