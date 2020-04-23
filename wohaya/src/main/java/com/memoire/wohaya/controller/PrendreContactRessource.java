package com.memoire.wohaya.controller;

import com.memoire.wohaya.model.PrendreContact;
import com.memoire.wohaya.services.PrendreContactService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/wohaya-api/contact")
@Api(value="Gestion des Prises de contact entre Clients et Propriétaires")
public class PrendreContactRessource {

    private final PrendreContactService prendreContactService;

    public PrendreContactRessource(PrendreContactService prendreContactService) {
        this.prendreContactService = prendreContactService;
    }

    @PostMapping("/add")
    public ResponseEntity<PrendreContact> save(@RequestBody PrendreContact prendreContact){
        if(prendreContact.getDateContact() == null){
            prendreContact.setDateContact(LocalDate.now(ZoneId.of("Africa/Porto-Novo")));
        }
        return new ResponseEntity<>(prendreContactService.save(prendreContact), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<PrendreContact>> getAll(){
        return new ResponseEntity<>(prendreContactService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrendreContact> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(prendreContactService.findOne(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrendreContact> update(@PathVariable("id") Long id, @RequestBody PrendreContact prendreContact){
        if (existId(id)){
            return new ResponseEntity<>(prendreContactService.update(prendreContact), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return prendreContactService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return prendreContactService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        prendreContactService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        prendreContactService.deleteAll();
    }

}
