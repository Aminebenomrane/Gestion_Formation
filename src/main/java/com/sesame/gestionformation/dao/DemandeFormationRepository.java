package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.DemandeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface DemandeFormationRepository extends JpaRepository<DemandeFormation,Long> {
    List<DemandeFormation> findByHeureFormationAndCollaborateur(Date heureFormation, Integer idCollaborateur);
    @Query("SELECT d.iddemande,d.etat,f.idformation,f.titre, f.description,f.specialite,f.date_formation,f.heure_formation FROM Formation f INNER JOIN f.demandeFormations d WHERE d.etat = 'valider'")
  List<Object[]>findAllDemandeValid();
}
