package com.sesame.gestionformation.validators;

import com.sesame.gestionformation.dto.DemandeFormationDto;

import java.util.ArrayList;
import java.util.List;

public class DemandeFormationValidator {
    public static List<String>validate(DemandeFormationDto d){
        List<String>errors=new ArrayList<>();
        if (d.getFormation()==null){
            errors.add("il faut la demande de formation avoir une idformation valide");
        }
        if (d.getCollaborateur()==null){
            errors.add("il faut la demande de formation avoir une idCollaborateur valide");
        }
        return errors;
    }
}
