package com.sesame.gestionformation.controller.api;

import com.sesame.gestionformation.dto.ResponsableDto;
import com.sesame.gestionformation.model.Responsable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.sesame.gestionformation.utils.Constants.Api_Root;
public interface Responsableapi {
    @PostMapping(value = Api_Root+"/responsable/create")
    ResponsableDto save(@RequestBody ResponsableDto formateur);
    @GetMapping(value = Api_Root + "/responsable/{iduser}")
    ResponsableDto findById(@PathVariable("iduser") Integer id);
    @GetMapping(value = Api_Root+"/responsable/All")
    List<ResponsableDto> findAll();

    @DeleteMapping(value = Api_Root + "/responsable/delete/{iduser}")
    void delete(@PathVariable("iduser") Integer id);
    @PutMapping(value = Api_Root+"/responsable/{id}")
    ResponseEntity<Responsable> updateResponsable(@PathVariable Integer id,
                                                  @RequestBody Responsable responsable);
}
