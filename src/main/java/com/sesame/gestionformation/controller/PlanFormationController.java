package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.PlanFormationapi;
import com.sesame.gestionformation.model.PlanFormation;
import com.sesame.gestionformation.services.PlanFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class PlanFormationController implements PlanFormationapi {
    PlanFormationService planFormationService;
@Autowired
    public PlanFormationController(PlanFormationService planFormationService) {
        this.planFormationService = planFormationService;
    }

    @Override
    public PlanFormation save(PlanFormation plan) {
        return planFormationService.save(plan);
    }

    @Override
    public Optional<PlanFormation> findById(Long id) {
        return planFormationService.findById(id);
    }

    @Override
    public List<PlanFormation> findAll() {
        return planFormationService.findAll();
    }

    @Override
    public void delete(Long id) {
planFormationService.delete(id);
    }

    @Override
    public void genererPlanPourChaqueFormation(PlanFormation planFormation) {
planFormationService.genererPlanPourChaqueFormation(planFormation);
    }

    @Override
    public void genererPlanGlobal(String titre) {
planFormationService.genererPlanGlobal(titre);
    }
}
