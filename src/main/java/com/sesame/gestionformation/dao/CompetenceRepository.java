package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompetenceRepository extends JpaRepository<Competence,Long> {
}
