package com.tacheservice.repository;

import com.tacheservice.model.tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<tache, Integer> {

}
