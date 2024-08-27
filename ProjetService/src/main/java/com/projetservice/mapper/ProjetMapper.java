package com.projetservice.mapper;

import com.projetservice.dto.projetDto;
import com.projetservice.model.projet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjetMapper {
    ProjetMapper INSTANCE = Mappers.getMapper(ProjetMapper.class);
    
    projetDto projetToProjetDto(projet projet);
    projet projetDtoToProjet(projetDto projetDto);

}
