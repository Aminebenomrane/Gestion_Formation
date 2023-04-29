package com.sesame.gestionformation.validators;

import com.sesame.gestionformation.dto.CompetenceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompetenceValidator {
    public static List<String> validate(CompetenceDto competenceDto){
        List<String> errors=new ArrayList<>();
        if (!StringUtils.hasLength(competenceDto.getNom())){
            errors.add("il faut remplir le Nom de compétence");
        }
        if (!StringUtils.hasLength(competenceDto.getLien())){
            errors.add("Il faut remplir lien de compétence");
        }

        return errors;
    }

}
