package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.UtilisateurDto;

import com.sesame.gestionformation.model.Utilisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

//@Api(Api_Root+"/Utilisateurs")
public interface Utilisateurapi {


    @PostMapping(value = Api_Root + "/utilisateurs/create")
    Utilisateur save(@RequestBody Utilisateur user);
    @GetMapping(value = Api_Root + "/utilisateurs/{iduser}")
    Optional<Utilisateur> findById(@PathVariable("iduser") Integer id);
    @GetMapping(value = Api_Root + "/utilisateurs/All")
    List<Utilisateur> findAll();
    @DeleteMapping(value = Api_Root + "/utilisateurs/delete/{iduser}")
    void delete(@PathVariable("iduser") Integer id);


}
