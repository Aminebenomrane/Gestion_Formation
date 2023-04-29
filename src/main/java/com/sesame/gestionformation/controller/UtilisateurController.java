package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.Utilisateurapi;
import com.sesame.gestionformation.dto.UtilisateurDto;
import com.sesame.gestionformation.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UtilisateurController implements Utilisateurapi {
    UtilisateurService utilisateurService;
@Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto user) {
        return utilisateurService.save(user);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
utilisateurService.delete(id);
    }
}
