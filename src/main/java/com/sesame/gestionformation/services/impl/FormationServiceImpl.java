package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.FormationRepository;
import com.sesame.gestionformation.model.Formation;
import com.sesame.gestionformation.model.Responsable;
import com.sesame.gestionformation.services.FormationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class FormationServiceImpl implements FormationService {
@Autowired
    FormationRepository formationRepository;
    @Override
    public Formation save(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Optional<Formation> findById(Long id) {
        return formationRepository.findById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }



    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("id {} de formation est null ",id);
        }
        formationRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Formation> updateFormation(Long id, Formation formation) {
        Optional<Formation> optionalFormation = formationRepository.findById(id);

        if (!optionalFormation.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Formation existingFormation = optionalFormation.get();




        existingFormation.setTitre(formation.getTitre());
        existingFormation.setDescription(formation.getDescription());
        existingFormation.setNiveau(formation.getNiveau());

        existingFormation.setSpecialite(formation.getSpecialite());
        existingFormation.setDate_formation(formation.getDate_formation());

        existingFormation.setCout(formation.getCout());
        existingFormation.setHeure_formation(formation.getHeure_formation());
        existingFormation.setQuota_max(formation.getQuota_max());

        Formation updateFormation = formationRepository.save(existingFormation);



        return ResponseEntity.ok(updateFormation);
    }


}
