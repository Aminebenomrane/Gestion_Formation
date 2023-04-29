package com.sesame.gestionformation.services;

import com.sesame.gestionformation.dto.UtilisateurDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto user);
    UtilisateurDto findById(Integer id);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
}
