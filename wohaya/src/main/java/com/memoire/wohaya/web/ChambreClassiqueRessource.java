package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.ChambreClassique;
import com.memoire.wohaya.services.ChambreClassiqueService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/wohaya-api/chclassique")
@RestController
@Api(value="Gestion des Chambres à louer")
public class ChambreClassiqueRessource {

    private final ChambreClassiqueService chambreClassiqueService;

    public ChambreClassiqueRessource(ChambreClassiqueService chambreClassiqueService) {
        this.chambreClassiqueService = chambreClassiqueService;
    }

    @PostMapping("/add")
    public ResponseEntity<ChambreClassique> save(@RequestBody ChambreClassique chambreClassique){
        return new ResponseEntity<>(chambreClassiqueService.save(chambreClassique), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<ChambreClassique>> getAll(){
        return new ResponseEntity<>(chambreClassiqueService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreClassique> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(chambreClassiqueService.findOne(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChambreClassique> update(@PathVariable("id") Long id, @RequestBody ChambreClassique chambreClassique){
        if (existId(id)){
            return new ResponseEntity<>(chambreClassiqueService.update(chambreClassique), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return chambreClassiqueService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return chambreClassiqueService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        chambreClassiqueService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        chambreClassiqueService.deleteAll();
    }

}
