package com.sesame.gestionformation.validators;

import com.sesame.gestionformation.dto.CollaborateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaborateurValidator {
    public static List<String> validate(CollaborateurDto collaborateurDto) {
        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasLength(collaborateurDto.getNiveau())) {
            errors.add("Il faut ajouter le niveau du collaborateur");

        }
        if (!StringUtils.hasLength(collaborateurDto.getDiplome())) {
            errors.add("Il faut ajouter le Diplome du collaborateur");

        }
        return errors;}
      
    }
