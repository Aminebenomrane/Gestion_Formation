package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.dao.CollaborateurRepository;
import com.sesame.gestionformation.dao.CompetenceRepository;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

@RestController
public class CollaborateurCompetenceController {
    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @PostMapping(value=Api_Root +"/collaborateurs/{id}/competences")
    public ResponseEntity<Void> addCompetenceToCollaborateur(@PathVariable Integer id, @RequestBody Competence competence) {
        Optional<Collaborateur> optionalCollaborateur = collaborateurRepository.findById(id);
        Optional<Competence> optionalCompetence = competenceRepository.findById(competence.getId());
        if (!optionalCollaborateur.isPresent() || !optionalCompetence.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Collaborateur collaborateur = optionalCollaborateur.get();
        Competence competenceToAdd = optionalCompetence.get();
        if (collaborateur.getCompetences().contains(competenceToAdd)) {
            return ResponseEntity.badRequest().build();
        }
        collaborateur.getCompetences().add(competenceToAdd);
        collaborateurRepository.save(collaborateur);
        return ResponseEntity.ok().build();
    }



    @PostMapping(value = Api_Root + "/collaborateurs/{id}/competences/{competenceId}")
    public ResponseEntity<Void> addCompetenceToCollaborateurr(@PathVariable Integer id, @PathVariable Long competenceId) {
        Optional<Collaborateur> optionalCollaborateur = collaborateurRepository.findById(id);
        Optional<Competence> optionalCompetence = competenceRepository.findById(competenceId);

        if (!optionalCollaborateur.isPresent() || !optionalCompetence.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Collaborateur collaborateur = optionalCollaborateur.get();
        Competence competenceToAdd = optionalCompetence.get();

        if (collaborateur.getCompetences().contains(competenceToAdd)) {
            return ResponseEntity.badRequest().build();
        }

        collaborateur.getCompetences().add(competenceToAdd);
        collaborateurRepository.save(collaborateur);

        return ResponseEntity.ok().build();
    }




    @GetMapping(value=Api_Root +"/collaborateurs/{id}/competences")
    public ResponseEntity<List<Competence>> getCompetencesForCollaborateur(@PathVariable Integer id) {
        Optional<Collaborateur> optionalCollaborateur = collaborateurRepository.findById(id);
        if (!optionalCollaborateur.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Collaborateur collaborateur = optionalCollaborateur.get();
        List<Competence> competences = collaborateur.getCompetences();
        return ResponseEntity.ok(competences);
    }

    @DeleteMapping(value=Api_Root +"/collaborateurs/{id}/competences/{competenceId}")
    public ResponseEntity<Void> removeCompetenceFromCollaborateur(@PathVariable Integer id, @PathVariable Long competenceId) {
        Optional<Collaborateur> optionalCollaborateur = collaborateurRepository.findById(id);
        Optional<Competence> optionalCompetence = competenceRepository.findById(competenceId);
        if (!optionalCollaborateur.isPresent() || !optionalCompetence.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Collaborateur collaborateur = optionalCollaborateur.get();
        Competence competenceToRemove = optionalCompetence.get();
        if (!collaborateur.getCompetences().contains(competenceToRemove)) {
            return ResponseEntity.badRequest().build();
        }
        collaborateur.getCompetences().remove(competenceToRemove);
        collaborateurRepository.save(collaborateur);
        return ResponseEntity.ok().build();
    }


    //
    @GetMapping(value=Api_Root +"/collaborateurs/competences/{competenceId}/collaborateurs")
    public ResponseEntity<List<Collaborateur>> getCollaborateursForCompetence(@PathVariable Long competenceId) {
        Optional<Competence> competenceOptional = competenceRepository.findById(competenceId);
        if (!competenceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Competence competence = competenceOptional.get();
        List<Collaborateur> collaborateurs = competence.getCollaborateurs();
        return ResponseEntity.ok(collaborateurs);
    }
}
