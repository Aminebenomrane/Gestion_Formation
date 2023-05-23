package com.sesame.gestionformation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Collaborateur extends Utilisateur {

    @Column(name = "niveau")
    private String niveau;
    @Column(name = "diplome")
    private String diplome;
    @JsonIgnore
    @OneToMany(mappedBy = "collaborateur" )
    List<DemandeFormation>demandeFormations;

    @ManyToMany
    @JoinTable(
            name = "collaborateur_competence",
            joinColumns = @JoinColumn(name = "collaborateur_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    @JsonIgnore
    private  List<Competence>competences;

}
