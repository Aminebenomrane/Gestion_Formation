package com.sesame.gestionformation.handlers;

import com.sesame.gestionformation.exception.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private Integer httpcode;
    private ErrorCodes code;
    private String message ;
    private List<String> errors=new ArrayList<>();

}
