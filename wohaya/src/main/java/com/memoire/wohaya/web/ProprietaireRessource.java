package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Proprietaire;
import com.memoire.wohaya.services.ProprietaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequestMapping("proprietaire")
@RestController
public class ProprietaireRessource {

    private final ProprietaireService proprietaireService;

    public ProprietaireRessource(ProprietaireService proprietaireService) {
        this.proprietaireService = proprietaireService;
    }

    @PostMapping("/add")
    public ResponseEntity<Proprietaire> save(@RequestBody Proprietaire proprietaire){
        if(proprietaire.getDebutAbonnement() == null) {
            proprietaire.setDebutAbonnement(LocalDate.now(ZoneId.of("Africa/Porto-Novo")));
        }
        proprietaire.setFinAbonnement(proprietaire.getDebutAbonnement().plusMonths(proprietaire.getAbonnement().getDuree()));
        if(proprietaire.getAbonnement() != null && proprietaire.getFinAbonnement().isAfter(LocalDate.now(ZoneId.of("Africa/Porto-Novo")))){
            proprietaire.setEtatAbonnement("actif");
        }else {
            proprietaire.setEtatAbonnement("inactif");
        }
        return new ResponseEntity<>(proprietaireService.save(proprietaire), HttpStatus.CREATED);

    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Proprietaire>> getAll(){
        return new ResponseEntity<>(proprietaireService.getAll(), HttpStatus.FOUND);
    }

}
