package com.ressourceservice.mapper;


import com.ressourceservice.Dto.RessourceDto;
import com.ressourceservice.model.Ressource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RessourceMapper {
    RessourceMapper INSTANCE = Mappers.getMapper(RessourceMapper.class);

    RessourceDto ressourceToRessourceDto(Ressource ressource);
    Ressource ressourceDtoToRessource(RessourceDto ressourceDto);
}
