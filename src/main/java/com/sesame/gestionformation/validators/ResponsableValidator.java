package com.sesame.gestionformation.validators;


import com.sesame.gestionformation.dto.ResponsableDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ResponsableValidator {
    public static List<String> validate(ResponsableDto formateurDto){
        List<String>errors=new ArrayList<>();
        if (!StringUtils.hasLength(formateurDto.getGrade())){
            errors.add("Il faut ajouter le grade du formateur");

        }
        if (!StringUtils.hasLength(formateurDto.getSpecialite())){
            errors.add("Il faut ajouter la spécialité du formateur");

        }
        return errors;

    }
}
