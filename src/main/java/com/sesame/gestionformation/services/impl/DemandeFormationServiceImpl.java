package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.CollaborateurRepository;
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
    private final CollaborateurRepository collaborateurRepository;

@Autowired
    public DemandeFormationServiceImpl(DemandeFormationRepository demandeFormationRepository, CollaborateurRepository collaborateurRepository) {
        this.demandeFormationRepository = demandeFormationRepository;
    this.collaborateurRepository = collaborateurRepository;
}
    public DemandeFormation createDemandeFormation(DemandeFormation demandeFormation) {
        if (demandeFormation.getIddemande() != null) {
            throw new InvalidEntityException("ID de demande de formation déjà défini");
        }
        Formation formation = demandeFormation.getFormation();
        Collaborateur collaborateur = demandeFormation.getCollaborateur();

        if (formation != null && collaborateur != null) {
            Formation formationEnBase = formationRepository.findById(formation.getIdformation()).orElse(null);
            Collaborateur collaborateur1 = collaborateurRepository.findById(collaborateur.getId_user()).orElse(null);

            if (formationEnBase != null && collaborateur1 != null) {
                // Vérifier si une demande de formation avec le même ID collaborateur et ID formation existe déjà
                boolean demandeExistante = demandeFormationRepository.existsByFormationAndCollaborateur(formationEnBase, collaborateur1);

                if (!demandeExistante && (formationEnBase.getQuota_max() > formationEnBase.getNbre_places())) {
                    demandeFormation.setFormation(formationEnBase);
                    demandeFormation.setCollaborateur(collaborateur1);
                    demandeFormation.setEtat(EtatDemande.En_cours);
                    demandeFormation.setHeureFormation(new Date());

                    return demandeFormationRepository.save(demandeFormation);
                } else {
                    throw new InvalidEntityException("Enregistrement échoué : demande de formation déjà existante ou nombre de places insuffisant");
                }
            } else {
                throw new InvalidEntityException("Enregistrement échoué : formation ou collaborateur non trouvé");
            }
        } else {
            throw new InvalidEntityException("Enregistrement échoué : formation ou collaborateur non trouvé");
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

         //Vérifier si la demande de formation est à l'état "en cours"
        if (demandeFormation.getEtat() != EtatDemande.En_cours) {
          //  throw new IllegalStateException("La demande de formation n'est pas à l'état 'en cours'");
        }

        // Vérifier si la formation a des places disponibles
        int nbPlaces = formation.getNbre_places();
        int quota = formation.getQuota_max();
        if (nbPlaces < quota) {
            formation.setNbre_places(nbPlaces + 1);
            demandeFormation.setEtat(EtatDemande.Valider);
        } else {
            throw new IllegalStateException("La formation a atteint le quota maximum de participants");
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

    @Override
    public List<Object[]> findAllValidDemande( Integer idCollaborateur) {
        return demandeFormationRepository.findAllDemandeValidForCollaborateur(idCollaborateur);
    }

    @Override
    public List<DemandeFormation> findAllEnCours() {
        return demandeFormationRepository.findAllByEtat(EtatDemande.En_cours);
    }

    @Override
    public List<DemandeFormation> findAllAnnuler() {
        return demandeFormationRepository.findAllByEtat(EtatDemande.Annuler);
    }

    @Override
    public List<DemandeFormation> findAllValider() {
        return demandeFormationRepository.findAllByEtat(EtatDemande.Valider);
    }
    @Override
    public List<DemandeFormation> getValiderDemandeFormationByUser(Collaborateur user) {
        return demandeFormationRepository.findByEtatAndCollaborateur(EtatDemande.Valider, user);
    }

    @Override
    public List<DemandeFormation> findDemandeByCollaborateur(Collaborateur collaborateur) {
        return demandeFormationRepository.findByCollaborateur(collaborateur);
    }


    @Override
    public List<DemandeFormation> getAnnulerDemandeFormationByUser(Collaborateur user) {
        return demandeFormationRepository.findByEtatAndCollaborateur(EtatDemande.Annuler, user);
    }

    @Override
    public List<DemandeFormation> getEnCoursDemandeFormationByUser(Collaborateur user) {
        return demandeFormationRepository.findByEtatAndCollaborateur(EtatDemande.En_cours, user);
    }

    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("id {} de formation est null ",id);
        }
        demandeFormationRepository.deleteById(id);
    }

}
