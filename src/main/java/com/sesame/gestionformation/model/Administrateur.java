package com.sesame.gestionformation.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.context.annotation.Bean;

@Entity
@Data

@AllArgsConstructor
@SuperBuilder
public class Administrateur extends Utilisateur {
}
