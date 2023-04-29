package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.model.DemandeFormation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;


public interface DemandeFormationapi {

    @PostMapping(value = Api_Root + "/demandeformation/create")
    DemandeFormation save(@RequestBody DemandeFormation demandeFormation);
    @PutMapping(value = Api_Root +"/valider/{idDemandeFormation}")
    DemandeFormation validerDemandeFormation(@PathVariable("idDemandeFormation")Long idDemandeFormation);
    @PutMapping(Api_Root +"/annuler/{idDemandeFormation}")
    DemandeFormation annulerDemandeFormation(@PathVariable("idDemandeFormation")Long idDemandeFormation);
    @GetMapping(value = Api_Root+"/demandeformation/{iddemande}")
    Optional<DemandeFormation> findById(@PathVariable("idDemandeFormation")Long id);
    @GetMapping(value = Api_Root+"/demandeformation/All")
    List<DemandeFormation> findAll();

}
