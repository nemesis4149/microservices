package com.esprit.reservations.repository;

import com.esprit.reservations.model.Serveur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeurRepository extends MongoRepository<Serveur, String> {
}
