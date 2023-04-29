package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.dto.UtilisateurDto;
import com.sesame.gestionformation.exception.EntityNotFoundException;
import com.sesame.gestionformation.exception.ErrorCodes;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.model.Utilisateur;
import com.sesame.gestionformation.services.UtilisateurService;
import com.sesame.gestionformation.validators.UtilisateurValidators;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    @Override
    public UtilisateurDto save(UtilisateurDto user) {
        List<String>errors= UtilisateurValidators.validate(user);
        if (!errors.isEmpty()){
            log.error("Utilisateur non valide {}",user);
            throw new InvalidEntityException(ErrorCodes.Utilisateur_Not_Valid,errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(user)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id==null){
            log.error("Id de utilisateur est nulle");
        }

        Optional<Utilisateur> user=utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(user.get())).orElseThrow(()->new EntityNotFoundException("Aucun Utilisateur avec l'id "+id+"n'est pas trouvé dans la base de donnée", ErrorCodes.Utilisateur_Not_Found));
    }

    @Override
    public List<UtilisateurDto> findAll() {

        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("User que vous voulez supprimé avec cette ID est n'est pas existe dans la base ");
            return;
        }
        utilisateurRepository.deleteById(id);

    }
}
