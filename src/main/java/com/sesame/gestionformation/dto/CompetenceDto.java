package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.Competence;
import com.sesame.gestionformation.model.Formation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDto {
    Long id;
    String nom;
    String lien;
    double score;
    Formation formation;
    List<Collaborateur> collaborateurs;
    public static CompetenceDto fromEntity(Competence competence){
        if (competence==null){
            return  null;
        }
       return CompetenceDto.builder()
               .id(competence.getId())
               .nom(competence.getNom())
               .lien(competence.getLien())
               .score(competence.getScore())

               .collaborateurs(competence.getCollaborateurs())
               .build();
    }
    public static Competence toEntity(CompetenceDto competenceDto){
        if (competenceDto==null){
            return null;
        }
        Competence c= new Competence();
        c.setId(competenceDto.getId());
        c.setNom(competenceDto.getNom());
        c.setLien(competenceDto.getLien());
        c.setScore(competenceDto.getScore());
        c.setCollaborateurs(competenceDto.getCollaborateurs());
        return c;
    }
}
