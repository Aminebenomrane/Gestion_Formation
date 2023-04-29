package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.DemandeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface DemandeFormationRepository extends JpaRepository<DemandeFormation,Long> {
    List<DemandeFormation> findByHeureFormationAndCollaborateur(Date heureFormation, Integer idCollaborateur);
}
