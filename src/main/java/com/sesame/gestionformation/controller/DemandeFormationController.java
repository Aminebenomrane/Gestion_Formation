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

import static com.sesame.gestionformation.utils.Constants.Api_Root;

@RestController
public class DemandeFormationController implements DemandeFormationapi {

    DemandeFormationService demandeFormationService;

    CollaborateurRepository cr;
    @Autowired
    public DemandeFormationController(DemandeFormationService demandeFormationService, CollaborateurRepository cr) {
        this.demandeFormationService = demandeFormationService;
        this.cr = cr;
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

    @Override
    public List<DemandeFormation> findAllAnnuler() {
        return demandeFormationService.findAllAnnuler();
    }



    @Override
    public ResponseEntity<List<DemandeFormation>> getValiderDemandeFormationByUser(Integer userId) {
        // Here, you would need to retrieve the Collaborateur object based on the provided userId

        Collaborateur user = cr.findById(userId).orElse(null);

        List<DemandeFormation> validerDemandeFormations = demandeFormationService.getValiderDemandeFormationByUser(user);
        return new ResponseEntity<>(validerDemandeFormations, HttpStatus.OK);
    }


   @Override
    public ResponseEntity<List<DemandeFormation>> getDemandeFormationsByCollaborateur(Integer id) {
        // Retrieve the collaborateur based on the ID (You need to implement this part)
        Collaborateur collaborateur = cr.findById(id).orElse(null);

        if (collaborateur == null) {
            // Collaborateur not found, return a 404 response
            return ResponseEntity.notFound().build();
        }

        // Retrieve the demandeFormations by collaborateur
        List<DemandeFormation> demandeFormations = demandeFormationService.findDemandeByCollaborateur(collaborateur);

        return ResponseEntity.ok(demandeFormations);
    }


    @Override
    public ResponseEntity<List<DemandeFormation>> getAnnulerDemandeFormationByUser(Integer userId) {
        // Here, you would need to retrieve the Collaborateur object based on the provided userId

        Collaborateur user = cr.findById(userId).orElse(null);

        List<DemandeFormation> annulerDemandeFormations = demandeFormationService.getAnnulerDemandeFormationByUser(user);
        return new ResponseEntity<>(annulerDemandeFormations, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DemandeFormation>> getEnCoursDemandeFormationByUser(Integer userId) {
        // Here, you would need to retrieve the Collaborateur object based on the provided userId

        Collaborateur user = cr.findById(userId).orElse(null);

        List<DemandeFormation> encoursDemandeFormations = demandeFormationService.getEnCoursDemandeFormationByUser(user);
        return new ResponseEntity<>(encoursDemandeFormations, HttpStatus.OK);
    }
}
