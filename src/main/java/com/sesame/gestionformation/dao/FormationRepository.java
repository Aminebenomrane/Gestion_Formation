package com.sesame.gestionformation.dao;

import com.sesame.gestionformation.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation,Long> {
    @Query("SELECT f, (SELECT COUNT(df) FROM DemandeFormation df WHERE df.formation = f) AS demandeCount FROM Formation f ORDER BY demandeCount DESC")
    List<Object[]> findTopFormations();


}
