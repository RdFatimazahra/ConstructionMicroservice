package com.tacheservice.controller;


import com.tacheservice.dto.TacheDto;
import com.tacheservice.model.tache;
import com.tacheservice.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    // Créer une nouvelle tâche
    @PostMapping("/projet/{projetId}")
//    public ResponseEntity<TacheDto> createTache(@PathVariable int projetId, @RequestBody TacheDto tacheDto) {
//        // Assigner l'ID du projet au DTO avant de créer la tâche
//        tacheDto.setIdProjet(projetId);
//        TacheDto createdTache = tacheService.createTache(tacheDto);
//        return ResponseEntity.ok(createdTache);

    public ResponseEntity<tache> createTache(@PathVariable int projetId, @RequestBody tache tacheDto) {
        // Assigner l'ID du projet au DTO avant de créer la tâche
        tacheDto.setIdProjet(projetId);
        tache createdTache = tacheService.createTache(tacheDto, projetId);
        return ResponseEntity.ok(createdTache);
    }


//    // Obtenir une tâche par ID
//    @GetMapping("/{id}")
//    public ResponseEntity<TacheDto> getTacheById(@PathVariable int id) {
//        TacheDto tacheDto = tacheService.getTacheById(id);
//        return ResponseEntity.ok(tacheDto);
//    }
//
//    // Obtenir toutes les tâches
//    @GetMapping
//    public ResponseEntity<List<TacheDto>> getAllTaches() {
//        List<TacheDto> taches = tacheService.getAllTaches();
//        return ResponseEntity.ok(taches);
//    }
//
//    // Obtenir les tâches par ID de projet
//    @GetMapping("/projet/{projetId}")
//    public ResponseEntity<List<TacheDto>> getTachesByProjetId(@PathVariable int projetId) {
//        List<TacheDto> taches = tacheService.getTachesByProjetId(projetId);
//        return ResponseEntity.ok(taches);
//    }
//
//    // Mettre à jour une tâche par ID
//    @PutMapping("/{id}")
//    public ResponseEntity<TacheDto> updateTache(@PathVariable int id, @RequestBody TacheDto tacheDto) {
//        TacheDto updatedTache = tacheService.updateTache(id, tacheDto);
//        return ResponseEntity.ok(updatedTache);
//    }
//
//    // Supprimer une tâche par ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTache(@PathVariable int id) {
//        tacheService.deleteTache(id);
//        return ResponseEntity.noContent().build();
//    }
}

