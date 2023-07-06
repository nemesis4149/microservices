package com.esprit.reservations.service;

import com.esprit.serveurs.exception.ServeurNotFoundException;
import com.esprit.serveurs.repository.ServeurRepository;
import com.esprit.serveurs.model.Serveur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServeurServiceImpl implements ServeurService {

    ServeurRepository serveurRepository;

    @Override
    public List<Serveur> getAllServeurs() {
        return serveurRepository.findAll();
    }

    @Override
    public Optional<Serveur> getServeurById(String id) {
        return serveurRepository.findById(id);
    }

    @Override
    public Serveur createServeur(Serveur serveur) {
        return serveurRepository.save(serveur);
    }

    @Override
    public Serveur updateServeur(Serveur serveurDto, String id) throws ServeurNotFoundException {
        Optional<Serveur> serveur = this.serveurRepository.findById(id);
        if (serveur.isPresent()) {
            return this.serveurRepository.save(serveurDto);
        } else {
            throw new ServeurNotFoundException(id);
        }
    }

    @Override
    public void deleteServeur(String id) {
        serveurRepository.deleteById(id);
    }
}
