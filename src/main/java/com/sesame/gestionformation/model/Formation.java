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
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @Enumerated(EnumType.STRING)
    Specialitess specialite;

    @Temporal(TemporalType.DATE)
    Date date_formation;

    @Temporal(TemporalType.TIME)
    Date heure_formation;
    @JsonIgnore
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    List<DemandeFormation>demandeFormations;
    String lien;
    double cout;
    int quota_max;
    int nbre_places;
@JsonIgnore
    @ManyToMany(mappedBy = "formation",cascade = CascadeType.ALL)
    private List<PlanFormation>planFormations;




}
