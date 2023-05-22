package com.sesame.gestionformation.controller;

import com.sesame.gestionformation.controller.api.Formationapi;
import com.sesame.gestionformation.model.Formation;
import com.sesame.gestionformation.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
public class FormationController implements Formationapi {
    @Autowired
    FormationService formationService;
    @Override
    public Formation save(Formation formation) {
        return formationService.save(formation);    }

    @Override
    public Optional<Formation> findById(Long id) {
        return formationService.findById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationService.findAll();
    }

    @Override
    public void delete(Long id) {
formationService.delete(id);
    }

    @Override
    public Formation updateFormation(Long id, Formation formation) {
        return formationService.updateFormation(id,formation);
    }
}
