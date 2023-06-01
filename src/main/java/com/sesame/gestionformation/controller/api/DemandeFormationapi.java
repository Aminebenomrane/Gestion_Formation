package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.model.DemandeFormation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;


public interface DemandeFormationapi {

    @PostMapping(value = Api_Root + "/dmandeformation")
    DemandeFormation createDemandeFormation(@RequestBody DemandeFormation demandeFormation);
    @PutMapping(value = Api_Root +"/valider/{idDemandeFormation}")
    DemandeFormation validerDemandeFormation(@PathVariable("idDemandeFormation")Long idDemandeFormation);
    @PutMapping(Api_Root +"/annuler/{idDemandeFormation}")
    DemandeFormation annulerDemandeFormation(@PathVariable("idDemandeFormation")Long idDemandeFormation);
    @GetMapping(value = Api_Root+"/demandeformation/{iddemande}")
    Optional<DemandeFormation> findById(@PathVariable("idDemandeFormation")Long id);
    @GetMapping(value = Api_Root+"/demandeformation/All")
    List<DemandeFormation> findAll();
    @GetMapping(value = Api_Root+"/nombrevalides")
    long getNombreDemandesValides();
    @GetMapping(value = Api_Root+"/nombreencours")
    long getNombreDemandesEnCours();
    @GetMapping(value = Api_Root+"/nombreannulees")
    long getNombreDemandesAnnulees();
    @GetMapping(value = Api_Root+"/demandeformation/valid/{idCollaborateur}")
    List<Object[]> findAllValidDemande(@PathVariable Integer idCollaborateur);
    @GetMapping(value = Api_Root+"/demandeformation/encours/All")
     List<DemandeFormation> findAllEnCours();
    @GetMapping(value = Api_Root+"/demandeformation/annuler/All")
    List<DemandeFormation> findAllAnnuler();
    @GetMapping(value = Api_Root+"/demandeformation/valider/All")
    List<DemandeFormation> findAllValider();
    @GetMapping(value = Api_Root+"/demandeformation/valider/{userId}")
     ResponseEntity<List<DemandeFormation>> getValiderDemandeFormationByUser(@PathVariable Integer userId);
    @GetMapping(value = Api_Root+"/demandeformation/collaborateur/{id}")
    public ResponseEntity<List<DemandeFormation>> getDemandeFormationsByCollaborateur(@PathVariable Integer id);
    @GetMapping(value = Api_Root+"/demandeformation/annuler/{userId}")
    ResponseEntity<List<DemandeFormation>> getAnnulerDemandeFormationByUser(@PathVariable Integer userId);
    @GetMapping(value = Api_Root+"/demandeformation/encours/{userId}")
    ResponseEntity<List<DemandeFormation>> getEnCoursDemandeFormationByUser(@PathVariable Integer userId);
    @DeleteMapping(value =Api_Root+ "/demandeformations/delete/{iddemande}")
    void delete(@PathVariable("iddemande") Long id);
}
