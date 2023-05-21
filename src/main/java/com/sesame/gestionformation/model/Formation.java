package com.sesame.gestionformation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idformation;
    String titre;
    String description;
    String niveau;

    String specialite;

    @Temporal(TemporalType.DATE)
    Date date_formation;

    @Temporal(TemporalType.TIME)
    Date heure_formation;
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    List<DemandeFormation>demandeFormations;
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
            List<Competence>competences;
    double cout;
    int quota_max;
    int nbre_places;

    @ManyToMany(mappedBy = "formation",cascade = CascadeType.ALL)
    private List<PlanFormation>planFormations;




}
