/*
package com.memoire.wohaya.controller;

import com.memoire.wohaya.model.Appreciation;
import com.memoire.wohaya.model.Publication;
import com.memoire.wohaya.model.Utilisateur;
import com.memoire.wohaya.services.AppreciationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.controller.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appreciation")
public class AppreciationRessource {

    private final AppreciationService appreciationService;

    public AppreciationRessource(AppreciationService appreciationService) {
        this.appreciationService = appreciationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Appreciation> save(@RequestBody Appreciation appreciation){
        return new ResponseEntity<>(appreciationService.save(appreciation), HttpStatus.CREATED);
    }

    @GetMapping("/find/{auteur}/{publication}")
    public Appreciation findOne(@PathVariable("auteur")Utilisateur utilisateur, @PathVariable("publication")Publication publication){
        return appreciationService.getOne(utilisateur, publication);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Appreciation>> getAll(){
        return new ResponseEntity<>(appreciationService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/count")
    public Long count(){
        return appreciationService.count();
    }

    @GetMapping("/exist/{auteur}/{publication}")
    public boolean existOne(@PathVariable("auteur")Utilisateur utilisateur, @PathVariable("publication")Publication publication){
        return appreciationService.exiistOne(utilisateur, publication);
    }

    @PutMapping("/{auteur}/{publication}")
    public ResponseEntity<Appreciation> update(@PathVariable("auteur")Utilisateur utilisateur, @PathVariable("publication")Publication publication, @RequestBody Appreciation appreciation){
        if(existOne(utilisateur, publication)){
            return new ResponseEntity<>(appreciationService.update(appreciation), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        appreciationService.deleteAll();
    }

}
*/
