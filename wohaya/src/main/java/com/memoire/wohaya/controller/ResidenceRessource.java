package com.memoire.wohaya.controller;

import com.memoire.wohaya.model.Residence;
import com.memoire.wohaya.services.ResidenceService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/wohaya-api/residence")
@RestController
@Api(value="Gestion des Résidences")
public class ResidenceRessource {

    private final ResidenceService residenceService;

    public ResidenceRessource(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Residence> save(@RequestBody Residence residence){
        return new ResponseEntity<>(residenceService.save(residence), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Residence>> getAll(){
        return new ResponseEntity<>(residenceService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residence> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(residenceService.findOne(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Residence> update(@PathVariable("id") Long id, @RequestBody Residence residence){
        if (existId(id)){
            return new ResponseEntity<>(residenceService.update(residence), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return residenceService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return residenceService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        residenceService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        residenceService.deleteAll();
    }

}
