package com.sesame.gestionformation.services;

import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.DemandeFormation;

import java.util.List;
import java.util.Optional;

public interface DemandeFormationService {
     DemandeFormation createDemandeFormation(DemandeFormation demandeFormation);
    DemandeFormation validerDemandeFormation(Long idDemandeFormation);
    DemandeFormation annulerDemandeFormation(Long idDemandeFormation);
    Optional<DemandeFormation> findById(Long id);
    List<DemandeFormation> findAll();
    List<Object[]> findAllValidDemande( Integer idCollaborateur);
    public List<DemandeFormation> findAllEnCours();
    public List<DemandeFormation> findAllAnnuler();
    public List<DemandeFormation> getValiderDemandeFormationByUser(Collaborateur user);
    List<DemandeFormation> findDemandeByCollaborateur(Collaborateur collaborateur);
    public List<DemandeFormation> getAnnulerDemandeFormationByUser(Collaborateur user);
    public List<DemandeFormation> getEnCoursDemandeFormationByUser(Collaborateur user);

}
