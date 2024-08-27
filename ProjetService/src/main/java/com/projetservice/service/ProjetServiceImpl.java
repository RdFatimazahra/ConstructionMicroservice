package com.projetservice.service;

import com.projetservice.dto.projetDto;
import com.projetservice.mapper.ProjetMapper;
import com.projetservice.model.projet;
import com.projetservice.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ProjetMapper projetMapper;

    @Override
    public projetDto createProjet(projetDto projetDto) {
        projet projetEntity = projetMapper.projetDtoToProjet(projetDto);
        projet savedProjet = projetRepository.save(projetEntity);
        return projetMapper.projetToProjetDto(savedProjet);
    }

    @Override
    public projetDto getProjetById(int id) {
        projet projetEntity = projetRepository.findById(id).orElse(null);
        return projetMapper.projetToProjetDto(projetEntity);
    }

    @Override
    public List<projetDto> getAllProjets() {
        List<projet> projets = projetRepository.findAll();
        return projets.stream()
                .map(projetMapper::projetToProjetDto)
                .collect(Collectors.toList());
    }

    @Override
    public projetDto updateProjet(int id, projetDto projetDto) {
        projet existingProjet = projetRepository.findById(id).orElse(null);
        if (existingProjet != null) {
            projet updatedProjet = projetMapper.projetDtoToProjet(projetDto);
            updatedProjet.setIdProjet(id); // Ensure the ID remains the same
            projetRepository.save(updatedProjet);
            return projetMapper.projetToProjetDto(updatedProjet);
        }
        return null;
    }

    @Override
    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }
}
