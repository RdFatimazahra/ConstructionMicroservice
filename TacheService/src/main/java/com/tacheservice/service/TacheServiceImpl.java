package com.tacheservice.service;

import com.tacheservice.ResourceNotFoundException;
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

    public  TacheDto createTache(TacheDto tacheDto, int idProjet) {
        restTemplate.getForObject("http://localhost:8081/api/projets/" + idProjet, Object.class);
        tache tache = tacheMapper.tacheDtoToTache(tacheDto);
        tache.setIdProjet(idProjet);
        tache savedTache = tacheRepository.save(tache);
        return tacheMapper.tacheToTacheDto(savedTache);

    }
//    public tache createTache(tache tache, int idProjet) {
//        try {
//            restTemplate.getForObject("http://localhost:8081/api/projets/" + idProjet, Object.class);
//        } catch (Exception e) {
//            throw new IllegalArgumentException("projet non trouve :" + e);
//        }
//        tache.setIdProjet(idProjet);
//        return tacheRepository.save(tache);
//    }
    @Override
    public List<TacheDto> getAllTaches() {
        List<tache> taches = tacheRepository.findAll();
        return taches.stream()
                .map(tacheMapper::tacheToTacheDto)
                .collect(Collectors.toList());
    }

    @Override
    public TacheDto getTacheById(int id) {
        tache tache = tacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tache not found with id: " + id));

        return tacheMapper.tacheToTacheDto(tache);
    }

    @Override
    public TacheDto updateTache(int id, TacheDto tacheDto) {
        tache existingTache = tacheRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tache not found with id: " + id));

        // Convert DTO to entity
        tache updatedTache = tacheMapper.tacheDtoToTache(tacheDto);
        updatedTache.setIdTache(id); // Ensure the ID is set

        // Save the updated entity
        tache savedTache = tacheRepository.save(updatedTache);

        // Convert entity back to DTO
        return tacheMapper.tacheToTacheDto(savedTache);
    }

    @Override
    public void deleteTache(int id) {
        tache existingTache = tacheRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tache not found with id: " + id));

        tacheRepository.delete(existingTache);
    }
}