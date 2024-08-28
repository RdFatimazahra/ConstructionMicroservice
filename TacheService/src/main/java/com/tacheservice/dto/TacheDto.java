package com.tacheservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TacheDto {
    private Long idTache;
    private Long idProjet;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String statut;
}
