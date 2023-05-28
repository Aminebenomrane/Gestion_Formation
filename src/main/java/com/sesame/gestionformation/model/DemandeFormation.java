package com.sesame.gestionformation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long iddemande;
    @Enumerated(EnumType.STRING)
    EtatDemande etat;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idformation")
    private Formation formation;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idcollaborateur")
    private Collaborateur collaborateur;
    @Column(name = "heure_formation")
    private Date heureFormation;
}
