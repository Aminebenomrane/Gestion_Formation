package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.ResponsableRepository;
import com.sesame.gestionformation.dao.UtilisateurRepository;
import com.sesame.gestionformation.exception.ErrorCodes;
import com.sesame.gestionformation.exception.InvalidEntityException;
import com.sesame.gestionformation.model.Responsable;
import com.sesame.gestionformation.model.Utilisateur;
import com.sesame.gestionformation.services.ResponsableService;
import com.sesame.gestionformation.validators.ResponsableValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ResponsableServiceImpl implements ResponsableService {
    @Autowired
    private ResponsableRepository responsableRepository;
    private  final PasswordEncoder passwordEncoder;
    @Autowired
    UtilisateurRepository utilisateurRepository;
@Autowired
    public ResponsableServiceImpl(ResponsableRepository responsableRepository, PasswordEncoder passwordEncoder) {
        this.responsableRepository = responsableRepository;
    this.passwordEncoder = passwordEncoder;
}

    @Override
    public Responsable save(Responsable responsable) {

        return responsableRepository.save(responsable);
    }

    @Override
    public Optional<Responsable> findById(Integer id){
        if (id==null){
            log.error("Id de responsable est nulle");
        }

        Optional<Responsable> user=responsableRepository.findById(id);
        return user;
    }

    @Override
    public List<Responsable> findAll() {
        return responsableRepository.findAll();
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
        Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findByEmail(responsable.getEmail());
        if (existingUtilisateurOptional.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOptional.get();
            if (!existingUtilisateur.getId_user().equals(existingResponsable.getId_user())) {
                return ResponseEntity.badRequest().body(null);
            }
        }
        existingResponsable.setEmail(responsable.getEmail());
        existingResponsable.setAge(responsable.getAge());
        existingResponsable.setNaissance(responsable.getNaissance());
        existingResponsable.setNom(responsable.getNom());
        existingResponsable.setPassword(passwordEncoder.encode(responsable.getPassword()));
        existingResponsable.setTelephone(responsable.getTelephone());
        existingResponsable.setPays(responsable.getPays());
        existingResponsable.setPrenom(responsable.getPrenom());
        existingResponsable.setPseudo(responsable.getPseudo());

        existingResponsable.setSpecialite(responsable.getSpecialite());

        Responsable updatedResponsable = responsableRepository.save(existingResponsable);

        if (updatedResponsable == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(updatedResponsable);
    }

    public Responsable findByEmail(String email) {
        return responsableRepository.findByEmail(email);
    }

}
