package com.tacheservice.repository;

import com.tacheservice.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Integer> {

    List<Tache> findByIdProjet(int projetId);
}
