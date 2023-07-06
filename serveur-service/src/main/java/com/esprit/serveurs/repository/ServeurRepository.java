package com.esprit.serveurs.repository;

import com.esprit.serveurs.model.Serveur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeurRepository extends MongoRepository<Serveur, String> {
}
