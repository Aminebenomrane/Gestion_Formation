package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Administrateur;
import com.sesame.gestionformation.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdministrateurRepository extends JpaRepository<Administrateur,Integer> {
}
