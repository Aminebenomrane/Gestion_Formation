package com.sesame.gestionformation.validators;

import com.sesame.gestionformation.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidators {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String>errors=new ArrayList<>();






        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Il faut ajouter l'email' d'utilisateur");

        }

        if (!StringUtils.hasLength(utilisateurDto.getPassword())){
            errors.add("Il faut ajouter le mots de passe d'utilisateur");

        }

        return errors;
    }

}
