package com.sesame.gestionformation.services;

import com.sesame.gestionformation.model.Competence;
import com.sesame.gestionformation.model.Formation;
import com.sesame.gestionformation.model.Responsable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface FormationService {
    Formation save(Formation formation);
    Optional<Formation> findById(Long id);
    List<Formation> findAll();
    void delete(Long id);
    Formation updateFormation(@PathVariable Long id,
                                                  @RequestBody Formation formation);
    List<Object[]> findFormationsPlusDemandees();
}

