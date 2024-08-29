package com.tacheservice.service;

import com.tacheservice.dto.TacheDto;
import com.tacheservice.mapper.TacheMapper;
import com.tacheservice.model.tache;
import com.tacheservice.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TacheServiceImpl implements TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TacheMapper tacheMapper;

    @Override
    public tache createTache(tache tache, int idProjet) {
        // Vérification si le projet associé existe
//        String projetServiceUrl = "http://localhost:8081/api/projets/" + idProjet;
//        Object projetExists = restTemplate.getForObject(projetServiceUrl, Object.class);
//
//        if (projetExists != null && projetExists) {
        // Convertir le DTO en entité
        //tache tache = tacheMapper.tacheDtoToTache(tacheDto);

        // S'assurer que l'ID du projet est bien assigné à la tâche
        //tache.setIdProjet(tacheDto.getIdProjet());

        // Sauvegarder l'entité dans la base de données
        //tache newTache = tacheRepository.save(tache);

        // Convertir l'entité sauvegardée en DTO et retourner le résultat
//            return tacheMapper.tacheToTacheDto(newTache);
//        } else {
//            throw new RuntimeException("Projet non trouvé");
//        }
        try {
            restTemplate.getForObject("http://localhost:8081/api/projets/" + idProjet, Object.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("projet non trouve :" + e);
        }
//        Taches tache = tachesMapper.toEntity(tachesDto);
        tache.setIdProjet(idProjet);
        return tacheRepository.save(tache);
//        return tachesMapper.toDto(tache);
    }


//
//
//    @Override
//    public TacheDto getTacheById(int id) {
//        // Find entity by id
//        Optional<tache> tacheOptional = tacheRepository.findById(id);
//
//        // Convert entity to DTO and return, or throw exception if not found
//        return tacheOptional.map(tacheMapper::tacheToTacheDto)
//                .orElseThrow(() -> new RuntimeException("Tache not found"));
//    }
//
//    @Override
//    public List<TacheDto> getAllTaches() {
//        // Find all entities and convert them to DTOs
//        return tacheRepository.findAll().stream()
//                .map(tacheMapper::tacheToTacheDto)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<TacheDto> getTachesByProjetId(int projetId) {
//        // Get the tasks related to the given project ID
//        List<tache> taches = tacheRepository.findByIdProjet(projetId);
//
//        // Convert the list of entities to DTOs and return
//        return taches.stream().map(tacheMapper::tacheToTacheDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public TacheDto updateTache(int id, TacheDto tacheDto) {
//        // Find the existing task by id
//        tache existingTache = tacheRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Tache not found"));
//
//        // Update the entity with new values
//        existingTache.setDescription(tacheDto.getDescription());
//        existingTache.setDateDebut(tacheDto.getDateDebut());
//        existingTache.setDateFin(tacheDto.getDateFin());
//        existingTache.setStatut(tacheDto.getStatut());
//
//        // Save the updated entity to the database
//        tache updatedTache = tacheRepository.save(existingTache);
//
//        // Convert the updated entity to DTO and return
//        return tacheMapper.tacheToTacheDto(updatedTache);
//    }
//
//    @Override
//    public void deleteTache(int id) {
//        // Find the task by id
//        tache tache = tacheRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Tache not found"));
//
//        // Delete the entity from the database
//        tacheRepository.delete(tache);
//    }

}
