package com.sesame.gestionformation.model;

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
    @OneToMany(mappedBy = "collaborateur" )
    List<DemandeFormation>demandeFormations;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "competence_collaborateur",
            joinColumns = @JoinColumn(name = "idcollaborateur"),
            inverseJoinColumns = @JoinColumn(name = "idcompetence")
    )
    private List<Competence> competences;

}
