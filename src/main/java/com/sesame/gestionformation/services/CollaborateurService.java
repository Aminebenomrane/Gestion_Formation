package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.CollaborateurDto;
import com.sesame.gestionformation.model.Collaborateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CollaborateurService {
    Collaborateur save(Collaborateur collaborateur);
    Optional<Collaborateur> findById(Integer id);
    List<Collaborateur> findAll();
    void delete(Integer id);



    ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Integer id,
                                                      @RequestBody Collaborateur collaborateur);
}
