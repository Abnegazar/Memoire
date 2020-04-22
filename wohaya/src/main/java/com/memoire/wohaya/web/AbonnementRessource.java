package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Abonnement;
import com.memoire.wohaya.services.AbonnementService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wohaya-api/abonnement")
@CrossOrigin
@Api(value="Gestion des Abonnement (Permis unique à l'Admin)")
public class AbonnementRessource {

    private final AbonnementService abonnementService;

    public AbonnementRessource(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Abonnement> save(@RequestBody Abonnement abonnement){
        return new ResponseEntity<>(abonnementService.save(abonnement), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Abonnement> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(abonnementService.getOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/find/{nbrAppart}/{nbrChambre}/{nbrResidence}")
    public ResponseEntity<List<Abonnement>> getMany(@PathVariable("nbrAppart") int nbrAppart, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrResidence") int nbrResidence){
        return new ResponseEntity<>(abonnementService.getMany(nbrAppart, nbrChambre, nbrResidence), HttpStatus.FOUND);
    }

    @GetMapping("/find/duree/{duree}")
    public ResponseEntity<List<Abonnement>> getMany(@PathVariable("duree") int duree){
        return new ResponseEntity<>(abonnementService.getByDuree(duree), HttpStatus.FOUND);
    }

    @GetMapping("/find/montant/{montant}")
    public ResponseEntity<List<Abonnement>> getByMontant(@PathVariable("montant") Long montant){
        return new ResponseEntity<>(abonnementService.getByMontant(montant), HttpStatus.FOUND);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Abonnement>> getAll(){
        return new ResponseEntity<>(abonnementService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/count")
    public Long countAll(){
        return abonnementService.count_all();
    }

    @GetMapping("/exist/id/{idAbonnement}")
    public boolean existAbonnemment(@PathVariable("idAbonnement") Long idAbonnement){
        return abonnementService.existOne(idAbonnement);
    }

    @GetMapping("/exist/montant/{montant}")
    public boolean existByMontant(@PathVariable("montant") Long montant){
        return abonnementService.existByMontant(montant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable("id") Long id, @RequestBody Abonnement abonnement){
        if(existAbonnemment(id)){
            return new ResponseEntity<>(abonnementService.update(abonnement), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        abonnementService.delete_all();
    }
}
