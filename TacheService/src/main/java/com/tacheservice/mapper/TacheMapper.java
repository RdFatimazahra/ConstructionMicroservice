package com.tacheservice.mapper;


import com.tacheservice.dto.TacheDto;
import com.tacheservice.model.tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    TacheDto toDto(tache tache);
    tache toEntity(TacheDto tacheDto);

}
