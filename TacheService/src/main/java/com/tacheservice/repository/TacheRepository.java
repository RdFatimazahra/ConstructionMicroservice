package com.tacheservice.repository;

import com.tacheservice.model.tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<tache, Integer> {

    List<tache> findByIdProjet(int projetId);
}
