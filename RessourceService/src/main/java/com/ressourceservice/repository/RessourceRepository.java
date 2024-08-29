package com.ressourceservice.repository;

import com.ressourceservice.model.Ressource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RessourceRepository extends CrudRepository<Ressource, Integer> {

    List<Ressource> findByIdTache(int idTache);
}
