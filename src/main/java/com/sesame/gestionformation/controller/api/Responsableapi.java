package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.ResponsableDto;
import com.sesame.gestionformation.model.Responsable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.sesame.gestionformation.utils.Constants.Api_Root;
public interface Responsableapi {
    @PostMapping(value = Api_Root+"/responsable/create")
    Responsable save(@RequestBody Responsable formateur);
    @GetMapping(value = Api_Root + "/responsable/{iduser}")
    Optional<Responsable> findById(@PathVariable("iduser") Integer id);
    @GetMapping(value = Api_Root+"/responsable/All")
    List<Responsable> findAll();

    @DeleteMapping(value = Api_Root + "/responsable/delete/{iduser}")
    void delete(@PathVariable("iduser") Integer id);
    @PutMapping(value = Api_Root+"/responsable/update/{id}")
    ResponseEntity<Responsable> updateResponsable(@PathVariable Integer id,
                                                  @RequestBody Responsable responsable);
}
