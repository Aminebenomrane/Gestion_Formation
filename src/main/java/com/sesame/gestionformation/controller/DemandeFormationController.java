package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.DemandeFormationapi;
import com.sesame.gestionformation.model.DemandeFormation;
import com.sesame.gestionformation.services.DemandeFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DemandeFormationController implements DemandeFormationapi {

    DemandeFormationService demandeFormationService;
@Autowired
    public DemandeFormationController(DemandeFormationService demandeFormationService) {
        this.demandeFormationService = demandeFormationService;
    }

    @Override
    public DemandeFormation save(DemandeFormation demandeFormation) {
        return demandeFormationService.save(demandeFormation);
    }

    @Override
    public DemandeFormation validerDemandeFormation(Long idDemandeFormation) {
        return demandeFormationService.validerDemandeFormation(idDemandeFormation);
    }

    @Override
    public DemandeFormation annulerDemandeFormation(Long idDemandeFormation) {
        return demandeFormationService.annulerDemandeFormation(idDemandeFormation);
    }

    @Override
    public Optional<DemandeFormation> findById(Long id) {
        return demandeFormationService.findById(id);
    }

    @Override
    public List<DemandeFormation> findAll() {
        return demandeFormationService.findAll();
    }
}
