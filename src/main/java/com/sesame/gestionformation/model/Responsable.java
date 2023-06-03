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

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Responsable extends Utilisateur {
     String grade;
     String specialite;

}
