package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.Collaborateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollaborateurDto
{
private String niveau;
private String diplome;
public static CollaborateurDto  fromEntity(Collaborateur collaborateur) {
    if (collaborateur == null) {
        return null;
    }
    return CollaborateurDto.builder()
            .niveau(collaborateur.getNiveau())
            .diplome(collaborateur.getDiplome())

            .build();
}
    public static Collaborateur toEntity(CollaborateurDto collaborateurDto){
        if (collaborateurDto==null){
            return null;
        }
        Collaborateur c =new Collaborateur();
        c.setNiveau(collaborateurDto.getNiveau());
        c.setDiplome(collaborateurDto.getDiplome());

        return c;
    }
}
