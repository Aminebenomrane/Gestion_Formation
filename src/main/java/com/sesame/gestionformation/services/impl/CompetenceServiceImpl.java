package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.CompetenceRepository;
import com.sesame.gestionformation.dto.CompetenceDto;
import com.sesame.gestionformation.model.Competence;
import com.sesame.gestionformation.services.ComptenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompetenceServiceImpl implements ComptenceService {
    CompetenceRepository competenceRepository;
@Autowired
    public CompetenceServiceImpl(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public Competence save(Competence competence) {
    return  competenceRepository.save(competence);



    }

    @Override
    public Optional<Competence> findById(Long id) {
  return   competenceRepository.findById(id);
    }

    @Override
    public List<Competence> findAll() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence updateComptence(Long id, Competence competence) {
    Optional<Competence> existingComptence= Optional.ofNullable(competenceRepository.findById(id).orElse(null));
    Competence competence1= existingComptence.get();
    competence1.setNom(competence.getNom());
    competence1.setLien(competence.getLien());
    competence1.setScore(competence.getScore());
        return competenceRepository.save(competence1);
    }

    @Override
    public void delete(Long id) {
    if (id == null){
        log.error("id est null");
        return;
    }
    competenceRepository.deleteById(id);

    }
}
