package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.DemandeFormationapi;
import com.sesame.gestionformation.dao.CollaborateurRepository;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.DemandeFormation;
import com.sesame.gestionformation.services.DemandeFormationService;
import com.sesame.gestionformation.services.impl.DemandeFormationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class DemandeFormationController implements DemandeFormationapi {

    DemandeFormationService demandeFormationService;

    CollaborateurRepository cr;
    @Autowired
    public DemandeFormationController(DemandeFormationService demandeFormationService) {
        this.demandeFormationService = demandeFormationService;

    }




    @Override
    public DemandeFormation createDemandeFormation(DemandeFormation demandeFormation) {
        return this.demandeFormationService.createDemandeFormation(demandeFormation);
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

    @Override
    public List<Object[]> findAllValidDemande( Integer idCollaborateur) {
        return demandeFormationService.findAllValidDemande(idCollaborateur);
    }

    @Override
    public List<DemandeFormation> findAllEnCours() {
        return demandeFormationService.findAllEnCours();
    }

    @GetMapping("/valider/{userId}")
    public ResponseEntity<List<DemandeFormation>> getValiderDemandeFormationByUser(@PathVariable Integer userId) {
        // Here, you would need to retrieve the Collaborateur object based on the provided userId

        Collaborateur user = cr.findById(userId).orElse(null);



        List<DemandeFormation> validerDemandeFormations = demandeFormationService.getValiderDemandeFormationByUser(user);
        return new ResponseEntity<>(validerDemandeFormations, HttpStatus.OK);
    }
}
