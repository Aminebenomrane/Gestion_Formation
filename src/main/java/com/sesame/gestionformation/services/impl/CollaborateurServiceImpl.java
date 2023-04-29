package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.CollaborateurRepository;
import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.dto.CollaborateurDto;
import com.sesame.gestionformation.exception.EntityNotFoundException;
import com.sesame.gestionformation.exception.ErrorCodes;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.services.CollaborateurService;
import com.sesame.gestionformation.validators.CollaborateurValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollaborateurServiceImpl implements CollaborateurService
{
    CollaborateurRepository collaborateurRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
@Autowired
    public CollaborateurServiceImpl(CollaborateurRepository collaborateurRepository) {
        this.collaborateurRepository = collaborateurRepository;
    }

    @Override
    public CollaborateurDto save(CollaborateurDto collaborateurDto) {
        List<String>errors= CollaborateurValidator.validate(collaborateurDto);
        if (!errors.isEmpty()){
            log.error("Colloaborateur non valide {}",collaborateurDto);
            throw new InvalidEntityException(ErrorCodes.Collaborateur_Not_Valid,errors);
        }
        return CollaborateurDto.fromEntity(collaborateurRepository.save(CollaborateurDto.toEntity(collaborateurDto)));
    }

    @Override
    public CollaborateurDto findById(Integer id) {
        if (id==null){
            log.error("Id de utilisateur est nulle");
        }

        Optional<Collaborateur> user=collaborateurRepository.findById(id);
        return Optional.of(CollaborateurDto.fromEntity(user.get())).orElseThrow(()->new EntityNotFoundException("Aucun Collaborateur avec l'id "+id+"n'est pas trouvé dans la base de donnée", ErrorCodes.Collaborateur_Not_Found));
    }

    @Override
    public List<CollaborateurDto> findAll() {
        return collaborateurRepository.findAll().stream().map(CollaborateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Collaborateur que vous voulez supprimé avec cette ID est n'est pas existe dans la base ");
            return;
        }

        collaborateurRepository.deleteById(id);

    }


@Override
@Transactional
    public ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Integer id,
                                                             @RequestBody Collaborateur collaborateur) {
    Optional<Collaborateur> optionalCollaborateur = collaborateurRepository.findById(id);

    if (!optionalCollaborateur.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    Collaborateur existingCollaborateur = optionalCollaborateur.get();




    existingCollaborateur.setNiveau(collaborateur.getNiveau());


    Collaborateur updatedCollaborateur = collaborateurRepository.save(existingCollaborateur);
    utilisateurRepository.save(existingCollaborateur);


    return ResponseEntity.ok(updatedCollaborateur);
}


}

