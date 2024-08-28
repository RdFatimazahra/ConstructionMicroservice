package com.tacheservice.service;

import com.tacheservice.dto.TacheDto;

import java.util.List;

public interface TacheService {
    TacheDto createTache(TacheDto tacheDto);
    TacheDto getTacheById(int id);
    List<TacheDto> getAllTaches();
    List<TacheDto> getTachesByProjetId(int projetId);
    TacheDto updateTache(int id, TacheDto tacheDto);
    void deleteTache(int id);
}
