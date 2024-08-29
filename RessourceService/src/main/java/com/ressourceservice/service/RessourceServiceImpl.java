package com.ressourceservice.service;

import com.ressourceservice.Dto.RessourceDto;
import com.ressourceservice.mapper.RessourceMapper;
import com.ressourceservice.model.Ressource;
import com.ressourceservice.repository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private RessourceMapper ressourceMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RessourceDto createRessource(RessourceDto ressourceDto, int idTache) {
        // Ensure the task (tache) exists by calling TacheService
        restTemplate.getForObject("http://localhost:8083/api/taches/" + idTache, Object.class);

        Ressource ressource = ressourceMapper.ressourceDtoToRessource(ressourceDto);
        ressource.setIdTache(idTache);
        Ressource savedRessource = ressourceRepository.save(ressource);

        return ressourceMapper.ressourceToRessourceDto(savedRessource);
    }

    @Override
    public RessourceDto getRessourceById(int id) {
        Ressource ressource = ressourceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resource not found"));
        return ressourceMapper.ressourceToRessourceDto(ressource);
    }

    @Override
    public List<RessourceDto> getAllRessources() {
        List<Ressource> ressources = (List<Ressource>) ressourceRepository.findAll();
        return ressources.stream()
                .map(ressourceMapper::ressourceToRessourceDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RessourceDto> getRessourcesByTacheId(int idTache) {
        List<Ressource> ressources = ressourceRepository.findByIdTache(idTache);
        return ressources.stream()
                .map(ressourceMapper::ressourceToRessourceDto)
                .collect(Collectors.toList());
    }

    @Override
    public RessourceDto updateRessource(int id, RessourceDto ressourceDto) {
        Ressource ressource = ressourceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resource not found"));

        ressource.setNom(ressourceDto.getNom());
        ressource.setType(ressourceDto.getType());
        ressource.setQuantite(ressourceDto.getQuantite());
        ressource.setFournisseur(ressourceDto.getFournisseur());

        Ressource updatedRessource = ressourceRepository.save(ressource);
        return ressourceMapper.ressourceToRessourceDto(updatedRessource);
    }

    @Override
    public void deleteRessource(int id) {
        Ressource ressource = ressourceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Resource not found"));
        ressourceRepository.delete(ressource);
    }
}
