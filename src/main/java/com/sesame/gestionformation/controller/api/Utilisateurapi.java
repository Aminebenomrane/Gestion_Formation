package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.UtilisateurDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

//@Api(Api_Root+"/Utilisateurs")
public interface Utilisateurapi {


    @PostMapping(value = Api_Root + "/utilisateurs/create")

    UtilisateurDto save(@RequestBody UtilisateurDto user);
    @GetMapping(value = Api_Root + "/utilisateurs/{iduser}")
    UtilisateurDto findById(@PathVariable("iduser") Integer id);
    @GetMapping(value = Api_Root + "/utilisateurs/All")
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = Api_Root + "/utilisateurs/delete/{iduser}")
    void delete(@PathVariable("iduser") Integer id);


}
