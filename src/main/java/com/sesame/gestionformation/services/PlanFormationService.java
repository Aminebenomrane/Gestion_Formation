package com.sesame.gestionformation.services;

import com.sesame.gestionformation.model.PlanFormation;

import java.util.List;
import java.util.Optional;

public interface PlanFormationService {
    PlanFormation save(PlanFormation plan);
    Optional<PlanFormation> findById(Long id);
    List<PlanFormation> findAll();
    void delete(Long id);
    void genererPlanPourChaqueFormation(PlanFormation planFormation);
   PlanFormation genererPlanGlobal(String titre);
}
