package com.sesame.gestionformation.services;

import com.sesame.gestionformation.model.Administrateur;

import java.util.List;
import java.util.Optional;

public interface AdministrateurService {
    Administrateur save(Administrateur admin);
    Optional<Administrateur> findById(Integer id);
    List<Administrateur> findAll();
    void delete(Integer id);
}
