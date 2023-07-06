package com.esprit.serveurs.controller;

import com.esprit.serveurs.exception.ServeurNotFoundException;
import com.esprit.serveurs.model.Serveur;
import com.esprit.serveurs.service.ServeurService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/serveurs")
@Api(value = "Serveur API")
@AllArgsConstructor
public class ServeurController {

    ServeurService serveurService;

    @GetMapping
    public ResponseEntity<List<Serveur>> getAllServeur() {
        List<Serveur> serveurs = this.serveurService.getAllServeurs();
        if (serveurs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(serveurs, HttpStatus.OK);
        }
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Serveur> getServeurById(@PathVariable("id") String id) {
        Optional<Serveur> serveur = this.serveurService.getServeurById(id);
        if (serveur.isPresent()) {
            return new ResponseEntity<>(serveur.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Serveur> createServeur(@RequestBody Serveur serveurDto) {
        Serveur serveur = this.serveurService.createServeur(serveurDto);
        return new ResponseEntity<>(serveur, HttpStatus.CREATED);

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Serveur> updateServeur(@PathVariable("id") String id, @RequestBody Serveur serveurDto) {
        try {
            return new ResponseEntity<>(this.serveurService.updateServeur(serveurDto, id), HttpStatus.OK);
        }catch (ServeurNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteServeur(@PathVariable("id") String id) {
        try {
            this.serveurService.deleteServeur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
