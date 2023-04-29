package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CollaborateurRepository extends JpaRepository<Collaborateur,Integer> {

}
