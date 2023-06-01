package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.UtilisateurDto;
import com.sesame.gestionformation.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur save(Utilisateur user);
    Optional<Utilisateur> findById(Integer id);
    List<Utilisateur> findAll();
    void delete(Integer id);
}
