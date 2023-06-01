package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.CollaborateurRepository;
import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.model.Collaborateur;
import com.sesame.gestionformation.dto.CollaborateurDto;
import com.sesame.gestionformation.exception.EntityNotFoundException;
import com.sesame.gestionformation.exception.ErrorCodes;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.model.Utilisateur;
import com.sesame.gestionformation.services.CollaborateurService;
import com.sesame.gestionformation.validators.CollaborateurValidator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private  final PasswordEncoder passwordEncoder;
    CollaborateurRepository collaborateurRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
@Autowired
    public CollaborateurServiceImpl(PasswordEncoder passwordEncoder, CollaborateurRepository collaborateurRepository) {
    this.passwordEncoder = passwordEncoder;
    this.collaborateurRepository = collaborateurRepository;
    }

    @Override
    public Collaborateur save(Collaborateur collaborateur) {

        return collaborateurRepository.save(collaborateur);
    }

    @Override
    public Optional<Collaborateur> findById(Integer id) {
        if (id==null){
            log.error("Id de utilisateur est nulle");
        }

        Optional<Collaborateur> user=collaborateurRepository.findById(id);
        return user;
    }

    @Override
    public List<Collaborateur> findAll() {
        return collaborateurRepository.findAll();
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

    Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findByEmail(collaborateur.getEmail());
    if (existingUtilisateurOptional.isPresent()) {
        Utilisateur existingUtilisateur = existingUtilisateurOptional.get();
        if (!existingUtilisateur.getId_user().equals(existingCollaborateur.getId_user())) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    existingCollaborateur.setEmail(collaborateur.getEmail());
    existingCollaborateur.setAge(collaborateur.getAge());
    existingCollaborateur.setNaissance(collaborateur.getNaissance());
    existingCollaborateur.setNom(collaborateur.getNom());
    existingCollaborateur.setPassword(passwordEncoder.encode(collaborateur.getPassword()));
    existingCollaborateur.setTelephone(collaborateur.getTelephone());
    existingCollaborateur.setPays(collaborateur.getPays());
    existingCollaborateur.setPrenom(collaborateur.getPrenom());
    existingCollaborateur.setPseudo(collaborateur.getPseudo());


    existingCollaborateur.setDiplome(collaborateur.getDiplome());
    existingCollaborateur.setNiveau(collaborateur.getNiveau());


    Collaborateur updatedCollaborateur = collaborateurRepository.save(existingCollaborateur);
    utilisateurRepository.save(existingCollaborateur);


    return ResponseEntity.ok(updatedCollaborateur);
}


}

