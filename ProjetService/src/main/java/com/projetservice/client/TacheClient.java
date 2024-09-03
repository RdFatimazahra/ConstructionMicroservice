package com.projetservice.client;


import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(name = "tache-service", url = "${application.config.taches-url}")
public class TacheClient {

    @GetMapping("/projet/{id}")
    List<Taches> findAllTachesByProjet(@PathVariable Long id);
    @DeleteMapping("/projet/delete/{id}")
    List<Taches> deleteTacheWithProjet(@PathVariable Long id);
}
