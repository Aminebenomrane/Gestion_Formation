package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.ResponsableRepository;
import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.dto.ResponsableDto;
import com.sesame.gestionformation.exception.EntityNotFoundException;
import com.sesame.gestionformation.exception.ErrorCodes;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.model.Responsable;
import com.sesame.gestionformation.services.ResponsableService;
import com.sesame.gestionformation.validators.ResponsableValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResponsableServiceImpl implements ResponsableService {
    private ResponsableRepository responsableRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
@Autowired
    public ResponsableServiceImpl(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository;
    }

    @Override
    public ResponsableDto save(ResponsableDto responsable) {
    List<String>errors= ResponsableValidator.validate(responsable);
        if (!errors.isEmpty()){
            log.error("responsable non valide {}",responsable);
            throw new InvalidEntityException(ErrorCodes.Responsable_Not_Valid,errors);
        }
        return ResponsableDto.fromEntity(responsableRepository.save(ResponsableDto.toEntity(responsable)));
    }

    @Override
    public ResponsableDto findById(Integer id){
        if (id==null){
            log.error("Id de responsable est nulle");
        }

        Optional<Responsable> user=responsableRepository.findById(id);
        return Optional.of(ResponsableDto.fromEntity(user.get())).orElseThrow(()->new EntityNotFoundException("Aucun responsable avec l'id "+id+"n'est pas trouvé dans la base de donnée", ErrorCodes.Responsable_Not_Found));
    }

    @Override
    public List<ResponsableDto> findAll() {
        return responsableRepository.findAll().stream().map(ResponsableDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id){
        if (id==null){
            log.error("responsable que vous voulez supprimé avec cette ID est n'est pas existe dans la base ");
            return;
        }
        responsableRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Responsable> updateResponsable(Integer id, Responsable responsable) {
        Optional<Responsable> optionalResponsable = responsableRepository.findById(id);

        if (!optionalResponsable.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Responsable existingResponsable = optionalResponsable.get();




        existingResponsable.setGrade(responsable.getGrade());
         existingResponsable.setSpecialite(responsable.getSpecialite());

        Responsable updatedResponsable = responsableRepository.save(existingResponsable);



        return ResponseEntity.ok(updatedResponsable);
    }

}
