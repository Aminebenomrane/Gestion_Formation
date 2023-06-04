package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.CompetenceDto;
import com.sesame.gestionformation.model.Administrateur;
import com.sesame.gestionformation.model.Competence;
import com.sesame.gestionformation.model.Formation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ComptenceService {
    Competence save(Competence competence);
    Optional<Competence> findById(Long id);
    List<Competence> findAll();
    Competence updateComptence( Long id,
                               Competence competence);
    void delete(Long id);
}
