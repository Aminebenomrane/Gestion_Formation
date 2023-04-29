package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.Comptenceapi;
import com.sesame.gestionformation.dto.CompetenceDto;
import com.sesame.gestionformation.model.Competence;
import com.sesame.gestionformation.services.ComptenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class ComptenceController implements Comptenceapi {
    ComptenceService comptenceService;
@Autowired
    public ComptenceController(ComptenceService comptenceService) {
        this.comptenceService = comptenceService;
    }

    @Override
    public Competence save(Competence competence) {
        return comptenceService.save(competence);
    }

    @Override
    public Optional<Competence> findById(Long id) {
        return comptenceService.findById(id);
    }

    @Override
    public List<Competence> findAll() {
        return comptenceService.findAll();
    }

    @Override
    public void delete(Long id) {
comptenceService.delete(id);
    }
}
