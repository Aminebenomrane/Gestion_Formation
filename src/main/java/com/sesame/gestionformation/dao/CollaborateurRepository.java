package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface CollaborateurRepository extends JpaRepository<Collaborateur,Integer> {
    @Query("SELECT c FROM Collaborateur c WHERE c.id_user = :idUser")
    Optional<Collaborateur> findById_user(@Param("idUser") Integer idUser);
}
