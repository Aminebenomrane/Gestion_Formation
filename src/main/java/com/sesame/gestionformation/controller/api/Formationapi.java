package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.model.Formation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import static com.sesame.gestionformation.utils.Constants.Api_Root;
public interface Formationapi {
    @PostMapping(value =Api_Root+"/formations/create")
    Formation save(@RequestBody Formation formation);
    @GetMapping(value = Api_Root+"/formtions/{idformation}")
    Optional<Formation> findById(@PathVariable("idformation") Long id);
    @GetMapping(value = Api_Root+"/formations/All")
    List<Formation> findAll();
    @DeleteMapping(value =Api_Root+ "/formations/{idformation}")
    void delete(@PathVariable("idformation") Long id);
    @PutMapping(value = Api_Root+"/formations/{id}")
    ResponseEntity<Formation> updateFormation(@PathVariable Long id,
                                              @RequestBody Formation formation);
}
