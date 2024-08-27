package com.projetservice.service;

import com.projetservice.dto.projetDto;

import java.util.List;

public class ProjetServiceImpl {

    public interface ProjetService {
        projetDto createProjet(projetDto projetDto);
        projetDto getProjetById(int id);
        List<projetDto> getAllProjets();
        projetDto updateProjet(int id, projetDto projetDto);
        void deleteProjet(int id);
    }
}
