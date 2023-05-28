package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.DemandeFormation;
import com.sesame.gestionformation.model.EtatDemande;
import com.sesame.gestionformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface DemandeFormationRepository extends JpaRepository<DemandeFormation,Long> {
    List<DemandeFormation> findByHeureFormationAndCollaborateur(Date heureFormation, Integer idCollaborateur);
    @Query("SELECT   f.titre, f.description, f.specialite, f.date_formation, f.heure_formation,d.etat " +
            "FROM Formation f INNER JOIN f.demandeFormations d " +
            "WHERE d.etat = 'valider' AND d.collaborateur.id_user = :idCollaborateur")
    List<Object[]> findAllDemandeValidForCollaborateur(@Param("idCollaborateur") Integer idCollaborateur);
    boolean existsByFormationAndCollaborateur(Formation formation, Collaborateur collaborateur);
    List<DemandeFormation> findAllByEtat(EtatDemande etat);
}
