package com.projetservice.repository;

import com.projetservice.model.projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<projet, Integer> {

}
