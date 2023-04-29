package com.sesame.gestionformation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String lien;
    double score;
    @ManyToOne
    @JoinColumn(name = "idformation")
    Formation formation;
    @ManyToMany(mappedBy = "competences", cascade = CascadeType.ALL)
    private List<Collaborateur> collaborateurs;

}
