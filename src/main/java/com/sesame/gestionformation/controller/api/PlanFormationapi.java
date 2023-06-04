package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.model.PlanFormation;
import org.springframework.web.bind.annotation.*;

import static com.sesame.gestionformation.utils.Constants.Api_Root;
import java.util.List;
import java.util.Optional;

public interface PlanFormationapi {
    @PostMapping(value=Api_Root+"/planformation/create")
    PlanFormation save(@RequestBody PlanFormation plan);
    @GetMapping(value = Api_Root+"/planformation/{idplan}")
    Optional<PlanFormation> findById(@PathVariable("idplan") Long id);
    @GetMapping(value = Api_Root + "/plan/All")
    List<PlanFormation> findAll();
    @DeleteMapping(value = Api_Root+"/planformation/{idplan}")
    void delete(@PathVariable("idplan") Long id);
    @PostMapping(value = Api_Root+"/genererplanbyformation")
    void genererPlanPourChaqueFormation(@RequestBody PlanFormation planFormation);
    @PostMapping(value = Api_Root+"/genererplanglobal")
    PlanFormation genererPlanGlobal(@RequestBody String titre);
}
