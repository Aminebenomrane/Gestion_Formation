package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.DemandeFormationRepository;
import com.sesame.gestionformation.dao.FormationRepository;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.DemandeFormation;
import com.sesame.gestionformation.model.EtatDemande;
import com.sesame.gestionformation.model.Formation;
import com.sesame.gestionformation.services.DemandeFormationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DemandeFormationServiceImpl implements DemandeFormationService {
    @Autowired
    private DemandeFormationRepository demandeFormationRepository;
    @Autowired
    private FormationRepository formationRepository;
@Autowired
    public DemandeFormationServiceImpl(DemandeFormationRepository demandeFormationRepository) {
        this.demandeFormationRepository = demandeFormationRepository;
    }
    @Override
    public DemandeFormation save(DemandeFormation demandeFormation) {
        if (demandeFormation.getIddemande() != null) {
            throw new InvalidEntityException("ID de demande de formation déjà défini");
        }

        Formation formation = demandeFormation.getFormation();
        if (formation != null && formation.getIdformation() != null) {
            Formation formationEnBase = formationRepository.findById(formation.getIdformation()).orElse(null);
            if (formationEnBase != null && (formationEnBase.getQuota_max()) > (formationEnBase.getNbre_places())) {
                demandeFormation.setEtat(EtatDemande.En_cours);
                return demandeFormationRepository.save(demandeFormation);
            } else {
                throw new InvalidEntityException("Enregistrement échoué : nombre de places insuffisant");
            }
        } else {
            throw new InvalidEntityException("Enregistrement échoué : ID de formation non défini");
        }
    }
    @Override
    public DemandeFormation validerDemandeFormation(Long idDemandeFormation) {


        // Vérifier que l'ID de la demande de formation n'est pas null
        if (idDemandeFormation == null) {
            throw new IllegalArgumentException("L'ID de la demande de formation ne peut pas être null");
        }

        // Rechercher la demande de formation correspondant à l'ID
        Optional<DemandeFormation> demandeFormationOpt = demandeFormationRepository.findById(idDemandeFormation);
        if (!demandeFormationOpt.isPresent()) {
            throw new NotFoundException("Demande de formation non trouvée avec l'ID : " + idDemandeFormation);
        }

        DemandeFormation demandeFormation = demandeFormationOpt.get();
        Formation formation = demandeFormation.getFormation();

        Collaborateur collaborateur = demandeFormation.getCollaborateur();
        Integer idCollaborateur = collaborateur.getId_user();

        // Rechercher les demandes de formation du même collaborateur à la même heure


        // Vérifier si la formation a des places disponibles
        int nbPlaces = formation.getNbre_places();
        int quota=formation.getQuota_max();
        if (nbPlaces <=quota ) {
            formation.setNbre_places(nbPlaces + 1);

            demandeFormation.setEtat(EtatDemande.Valider);
        }

        // Retourner la demande de formation mise à jour
        return demandeFormationRepository.save(demandeFormation);
    }

    @Override
    public DemandeFormation annulerDemandeFormation(Long idDemandeFormation) {
        DemandeFormation demandeFormation = demandeFormationRepository.findById(idDemandeFormation)
                .orElseThrow(() -> new NotFoundException("Demande de formation non trouvée avec l'ID : " + idDemandeFormation));

        // Logique d'annulation de la demande de formation
        demandeFormation.setEtat(EtatDemande.Annuler);

        return demandeFormationRepository.save(demandeFormation);
    }

    @Override
    public Optional<DemandeFormation> findById(Long id) {
        return demandeFormationRepository.findById(id);
    }

    @Override
    public List<DemandeFormation> findAll() {
        return demandeFormationRepository.findAll();
    }
}
