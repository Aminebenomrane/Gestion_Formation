package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.dto.UtilisateurDto;
import com.sesame.gestionformation.model.Utilisateur;
import com.sesame.gestionformation.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    @Override
    public Utilisateur save(Utilisateur user) {

        return utilisateurRepository.save(user);
    }

    @Override
    public Optional<Utilisateur> findById(Integer id) {
        if (id == null) {
            log.error("Id de utilisateur est nulle");
        }

        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        return user;
    }
    @Override
    public List<Utilisateur> findAll(){

        return utilisateurRepository.findAll();
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
