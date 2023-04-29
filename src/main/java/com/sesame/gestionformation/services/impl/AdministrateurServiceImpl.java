package com.sesame.gestionformation.services.impl;

import com.sesame.gestionformation.dao.AdministrateurRepository;
import com.sesame.gestionformation.model.Administrateur;
import com.sesame.gestionformation.services.AdministrateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class AdministrateurServiceImpl implements AdministrateurService {

AdministrateurRepository administrateurRepository;
@Autowired
    public AdministrateurServiceImpl(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public Administrateur save(Administrateur admin) {

        return administrateurRepository.save(admin);
    }

    @Override
    public Optional<Administrateur> findById(Long id) {
        if (id==null){
            log.error("Id de administrateur est nulle");
        }

     return  administrateurRepository.findById(id);

    }

    @Override
    public List<Administrateur> findAll() {
        return administrateurRepository.findAll();
    }

    @Override
    public void delete(Long id) {
administrateurRepository.deleteById(id);
    }
}
