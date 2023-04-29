package com.sesame.gestionformation.dto;

import com.sesame.gestionformation.model.Role;
import com.sesame.gestionformation.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDto {
    private Integer id_user;
    private String nom;
    private String prenom;
    private int age;
    private Date naissance;
    private int telephone;
    private String pays;
    private String email;
    private String pseudo;
    private String password;
    private Role role;
    public static UtilisateurDto fromEntity(Utilisateur user){
        if (user==null){
            return null;
        }
        return UtilisateurDto.builder()
                .id_user(user.getId_user())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .age(user.getAge())
                .naissance(user.getNaissance())
                .telephone(user.getTelephone())
                .pays(user.getPays())
                .email(user.getEmail())
                .pseudo(user.getPseudo())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto==null){
            return null;
        }
        Utilisateur u =new Utilisateur();
        u.setId_user(utilisateurDto.getId_user());
        u.setNom(utilisateurDto.getNom());
        u.setPrenom(utilisateurDto.getPrenom());
        u.setAge(utilisateurDto.getAge());
        u.setNaissance(utilisateurDto.getNaissance());
        u.setTelephone(utilisateurDto.getTelephone());
        u.setPays(utilisateurDto.getPays());
        u.setEmail(utilisateurDto.getEmail());
        u.setPseudo(utilisateurDto.getPseudo());
        u.setPassword(utilisateurDto.getPassword());
        u.setRole(utilisateurDto.getRole());
        return u;
    }

}
