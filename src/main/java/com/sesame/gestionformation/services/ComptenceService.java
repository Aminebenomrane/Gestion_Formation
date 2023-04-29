package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.CompetenceDto;
import com.sesame.gestionformation.model.Administrateur;
import com.sesame.gestionformation.model.Competence;

import java.util.List;
import java.util.Optional;

public interface ComptenceService {
    Competence save(Competence competence);
    Optional<Competence> findById(Long id);
    List<Competence> findAll();
    void delete(Long id);
}
