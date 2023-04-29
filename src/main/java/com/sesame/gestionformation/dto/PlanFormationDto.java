package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.PlanFormation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanFormationDto {
    Long id;
    String titre;
    Date date_debut;
    Date date_fin;
    int nombre_formations;
    int nombre_participants;
    double budget_total;
    double cout;
    public static PlanFormationDto fromEntity(PlanFormation planFormation){
        if (planFormation==null){
            return null;
        }
       return PlanFormationDto.builder()
                .id(planFormation.getId())
                .titre(planFormation.getTitre())
                .date_debut(planFormation.getDate_debut())
                .date_fin(planFormation.getDate_fin())
                .nombre_formations(planFormation.getNombre_formations())
                .nombre_participants(planFormation.getNombre_participants())
                .budget_total(planFormation.getBudget_total())
                .cout(planFormation.getCout())
                .build();
    }
    public static PlanFormation toEntity(PlanFormationDto planFormationDto){
        if (planFormationDto==null){
            return null;
        }
        PlanFormation p =new PlanFormation();
        p.setId(planFormationDto.getId());
        p.setBudget_total(planFormationDto.getBudget_total());
        p.setCout(planFormationDto.getCout());
        p.setTitre(planFormationDto.getTitre());
        p.setNombre_formations(planFormationDto.getNombre_formations());
        p.setDate_debut(planFormationDto.getDate_debut());
        p.setDate_fin(planFormationDto.getDate_fin());

        p.setNombre_participants(planFormationDto.getNombre_participants());

        return p;
    }

}
