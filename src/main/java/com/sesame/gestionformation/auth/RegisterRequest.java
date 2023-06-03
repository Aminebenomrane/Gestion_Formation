package com.sesame.gestionformation.auth;

import com.sesame.gestionformation.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private Role role;
    private int age ;
    private String grade ;
    private String specialite;
    private String diplome;
    private String niveau;
}
