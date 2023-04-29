package com.sesame.gestionformation.services;

import com.sesame.gestionformation.model.DemandeFormation;

import java.util.List;
import java.util.Optional;

public interface DemandeFormationService {
    DemandeFormation save(DemandeFormation demandeFormation);
    DemandeFormation validerDemandeFormation(Long idDemandeFormation);
    DemandeFormation annulerDemandeFormation(Long idDemandeFormation);
    Optional<DemandeFormation> findById(Long id);
    List<DemandeFormation> findAll();

}
