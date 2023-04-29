package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.CollaborateurDto;
import com.sesame.gestionformation.model.Collaborateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

public interface Collaobrateurapi {
    @PostMapping(value = Api_Root + "/collaborateur/create")
    CollaborateurDto save(@RequestBody CollaborateurDto collaborateurDto);
    @GetMapping(value = Api_Root + "/collaborateur/{idcollaborateur}")
    CollaborateurDto findById(@PathVariable("idcollaborateur") Integer id);
    @GetMapping(value = Api_Root + "/collaborateur/All")
    List<CollaborateurDto> findAll();
    @DeleteMapping(value = Api_Root + "/collaborateur/delete/{idcollaborateur}")
    void delete(@PathVariable("idcollaborateur") Integer id);
    @PostMapping("/competences/{competenceId}/collaborateur/{idcollaborateur}")
    ResponseEntity<String> ajouterCompetenceACollaborateur(Long comptenceid, Integer idcollaborateur);
    @PutMapping(value = Api_Root+"/collaborateur/{id}")
    ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Integer id,
                                                      @RequestBody Collaborateur collaborateur);
}
