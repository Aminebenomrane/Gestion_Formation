package com.sesame.gestionformation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titre;
    @Temporal(TemporalType.DATE)
    Date date_debut;
    @Temporal(TemporalType.DATE)
    Date date_fin;
    int nombre_formations;
    int nombre_participants;
    double budget_total;
    double cout;
    @ManyToMany
    @JoinColumn(name = "idformation")
    List<Formation> formation;


}
