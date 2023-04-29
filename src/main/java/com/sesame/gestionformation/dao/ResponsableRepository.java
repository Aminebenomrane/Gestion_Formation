package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ResponsableRepository extends JpaRepository<Responsable,Integer> {
}
