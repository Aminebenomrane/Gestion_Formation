package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.Utilisateurapi;
import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.dto.UtilisateurDto;
import com.sesame.gestionformation.model.Utilisateur;
import com.sesame.gestionformation.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

@RestController
public class UtilisateurController implements Utilisateurapi {
    UtilisateurService utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository ;
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

    @GetMapping(value = Api_Root+"/user/email/{email}")
    public Optional<Utilisateur> getUserByEmail(@PathVariable String email) {
        return Optional.ofNullable(utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }

    @PostMapping(value = Api_Root+"/user/email")
    public Optional<Utilisateur> getUserByEmaileee(@RequestBody String email) {
        return Optional.ofNullable(utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found")));
    }




}
