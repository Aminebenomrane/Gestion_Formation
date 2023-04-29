package com.sesame.gestionformation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@SuperBuilder
public class Responsable extends Utilisateur {
    @Column(name = "grade")
    private String grade;
    @Column(name = "specialite")
    private String specialite;

}
