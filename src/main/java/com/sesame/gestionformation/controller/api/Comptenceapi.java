package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.CompetenceDto;
import com.sesame.gestionformation.model.Competence;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;

public interface Comptenceapi {

    @PostMapping(value = Api_Root + "/competence/create")

    Competence save(@RequestBody Competence competence);
    @GetMapping(value = Api_Root + "/competence/{idcompetence}")
    Optional<Competence> findById(@PathVariable("idcompetence")Long id);
    @GetMapping(value = Api_Root + "/competence/All")
    List<Competence> findAll();
    @DeleteMapping(value = Api_Root + "/competence/delete/{idcompetence}")
    void delete(@PathVariable("idcompetence")Long id);


}
