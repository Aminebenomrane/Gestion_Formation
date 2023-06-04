package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.FormationRepository;
import com.sesame.gestionformation.dao.PlanFormationRepository;
import com.sesame.gestionformation.model.Formation;
import com.sesame.gestionformation.model.PlanFormation;
import com.sesame.gestionformation.services.PlanFormationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlanFormationServiceImpl implements PlanFormationService {

    PlanFormationRepository planFormationRepository;
    private FormationRepository formationRepository;

    @Autowired
    public PlanFormationServiceImpl(PlanFormationRepository planFormationRepository, FormationRepository formationRepository) {
        this.planFormationRepository = planFormationRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public PlanFormation save(PlanFormation plan) {
        return planFormationRepository.save(plan);
    }

    @Override
    public Optional<PlanFormation> findById(Long id) {
        return planFormationRepository.findById(id);
    }

    @Override
    public List<PlanFormation> findAll() {
        return planFormationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        planFormationRepository.deleteById(id);
    }

    @Override
    public void genererPlanPourChaqueFormation(PlanFormation planFormation) {
        for (Formation formation : planFormation.getFormation()) {



            double coutFormation = formation.getCout();
            int nombreParticipantsFormation = formation.getNbre_places();
            double budgetFormation = coutFormation * nombreParticipantsFormation;

            planFormation.setCout(coutFormation);
            planFormation.setNombre_participants(nombreParticipantsFormation);
            planFormation.setBudget_total(budgetFormation);

            System.out.println("Plan de formation pour la formation " + formation.getTitre() + ":");
            System.out.println("Coût de la formation : " + coutFormation);
            System.out.println("Nombre de participants : " + nombreParticipantsFormation);
            System.out.println("Budget pour la formation : " + budgetFormation);

            System.out.println("---------------");
        }}


    @Override
    public PlanFormation genererPlanGlobal(String titre) {
        PlanFormation planFormation = new PlanFormation();


        List<Formation> formations = formationRepository.findAll(); // Obtenir la liste de toutes les formations depuis la base de données

        if (!formations.isEmpty()) {
            int nombreFormations = formations.size();
            int nombreParticipantsTotal = 0;
            double coutTotal = 0.0;
            double budget=0.0;
 double budgetparformation=0.0;
            for (Formation formation : formations) {
                int nombreParticipantsFormation = formation.getNbre_places(); // Nombre de participants pour cette formation
                double coutFormation = formation.getCout(); // Coût de cette formation
coutTotal+=coutFormation;
nombreParticipantsTotal+=nombreParticipantsFormation;
  budgetparformation=coutFormation*nombreParticipantsFormation;
   budget+=budgetparformation;
            }

            double budgetTotal =budget;
            planFormation.setTitre("Plan formation de sesame");
            planFormation.setDate_debut(new Date());
            planFormation.setNombre_formations(nombreFormations);
            planFormation.setBudget_total(budgetTotal);
            planFormation.setNombre_participants(nombreParticipantsTotal);
            planFormation.setCout(coutTotal);

            // Enregistrer le plan de formation global dans la base Hibernate:
            //    insert
            //    into
            //        plan_formation
            //        (budget_total, cout, date_debut, date_fin, nombre_formations, nombre_participants, titre)
            //    values
            //        (?, ?, ?, ?, ?, ?, ?)
            //Plan de formation global créé avec succès !
            //Titre du plan : Plan formation de sesame
            //Nombre de formations : 3
            //Nombre total de participants : 258
            //Coût total : 1005.0
            //Budget total : 101775.0de données
            planFormation = planFormationRepository.save(planFormation);

            System.out.println("Plan de formation global créé avec succès !");
            System.out.println("Titre du plan : " + planFormation.getTitre());
            System.out.println("Nombre de formations : " + nombreFormations);
            System.out.println("Nombre total de participants : " + nombreParticipantsTotal);
            System.out.println("Coût total : " + coutTotal);
            System.out.println("Budget total : " + budgetTotal);

        } else {
            System.out.println("Aucune formation trouvée pour créer le plan de formation global.");
        }

        return planFormation;
    }
}

