package com.sesame.gestionformation.validators;

import com.sesame.gestionformation.dto.PlanFormationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PlanFormationValidator {
    public static List<String>validate(PlanFormationDto p){
        List<String>errors=new ArrayList<>();
        if (StringUtils.hasLength(p.getTitre())){
            errors.add("Il faut remplir le titre de Plan de formation");
        }
        if (p.getBudget_total()==Double.parseDouble(null)){
            errors.add("Il faut remplir le Budget totale de Plan de formation");
        }
        if (p.getCout()==Double.parseDouble(null)){
            errors.add("Il faut remplir le cout  de Plan de formation");
        }
        if (p.getNombre_formations()==Integer.parseInt(null)){
            errors.add("Il faut remplir le nombre des formations  totale de Plan de formation");
        }
        if (p.getNombre_participants()==Integer.parseInt(null)){
            errors.add("Il faut remplir le nombre des participants  totale de Plan de formation");
        }
        if (p.getDate_debut()==null){
            errors.add("Il faut saisir la date de début de plan de formation");
        }
        if (p.getDate_fin()==null){
            errors.add("Il faut saisir la date de fin de plan de formation");
        }
        return errors;
    }
}
