package com.memoire.wohaya.controller;

import com.memoire.wohaya.model.Proprietaire;
import com.memoire.wohaya.services.ProprietaireService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequestMapping("/wohaya-api/proprietaire")
@RestController
@Api(value="Gestion des Propriétaires")
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

    @GetMapping("/{id}")
    public ResponseEntity<Proprietaire> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(proprietaireService.findOne(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietaire> update(@PathVariable("id") Long id, @RequestBody Proprietaire proprietaire){
        if (existId(id)){
            return new ResponseEntity<>(proprietaireService.update(proprietaire), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return proprietaireService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return proprietaireService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        proprietaireService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        proprietaireService.deleteAll();
    }

}
