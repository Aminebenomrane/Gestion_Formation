package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.CollaborateurDto;
import com.sesame.gestionformation.model.Collaborateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CollaborateurService {
    CollaborateurDto save(CollaborateurDto collaborateurDto);
    CollaborateurDto findById(Integer id);
    List<CollaborateurDto> findAll();
    void delete(Integer id);



    ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Integer id,
                                                      @RequestBody Collaborateur collaborateur);
}
