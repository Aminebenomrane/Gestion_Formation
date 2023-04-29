package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeFormationDto {
    Long iddemande;
    private Formation formation;
    private Collaborateur collaborateur;
   private EtatDemande etat;
    public static DemandeFormationDto fromEntity(DemandeFormation demandeFormation){
        if (demandeFormation==null){
            return null;
        }
        return DemandeFormationDto.builder()
                .iddemande(demandeFormation.getIddemande())
                .etat(demandeFormation.getEtat())
                .formation(demandeFormation.getFormation())
                .collaborateur(demandeFormation.getCollaborateur())
                .build();
    }
    public  static DemandeFormation toEntity(DemandeFormationDto demandeFormationDto){
        if (demandeFormationDto==null){
            return null;
        }
        DemandeFormation d =new DemandeFormation();
        d.setIddemande(demandeFormationDto.getIddemande());
        d.setFormation(demandeFormationDto.getFormation());
d.setEtat(demandeFormationDto.getEtat());
        d.setCollaborateur(demandeFormationDto.getCollaborateur());
        return d;
    }
}
