package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.Responsable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsableDto {

    private String grade;

    private String specialite;
    public static ResponsableDto fromEntity(Responsable responsable){
        if (responsable==null){
            return null;
        }
        return ResponsableDto.builder()

                .specialite(responsable.getSpecialite())
                .build();}
    public static Responsable toEntity(ResponsableDto responsable){
        if (responsable==null){
            return null;
        }

        Responsable f =new Responsable();

        f.setSpecialite(responsable.getSpecialite());

        return f;
    }

    }

