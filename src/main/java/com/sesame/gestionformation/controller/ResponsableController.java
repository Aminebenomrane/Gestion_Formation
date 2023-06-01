package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.Responsableapi;
import com.sesame.gestionformation.dto.ResponsableDto;
import com.sesame.gestionformation.model.Responsable;
import com.sesame.gestionformation.services.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ResponsableController implements Responsableapi {
    @Autowired
    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    ResponsableService responsableService;
    @Override
    public Responsable save(Responsable formateur) {
        return responsableService.save(formateur);
    }

    @Override
    public Optional<Responsable> findById(Integer id) {
        return responsableService.findById(id);
    }

    @Override
    public List<Responsable> findAll() {
        return responsableService.findAll();
    }

    @Override
    public void delete(Integer id) {
 responsableService.delete(id);
    }

    @Override
    public ResponseEntity<Responsable> updateResponsable(Integer id, Responsable responsable) {
        return responsableService.updateResponsable(id,responsable);
    }

    @GetMapping("/responsables/email/{email}")
    public ResponseEntity<Responsable> findResponsableByEmail(@PathVariable String email) {
        Responsable responsable = responsableService.findByEmail(email);
        if (responsable != null) {
            return ResponseEntity.ok(responsable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
