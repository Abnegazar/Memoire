package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Annonce;
import com.memoire.wohaya.domaine.Localisation;
import com.memoire.wohaya.services.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wohaya-api/annonce")
public class AnnonceRessource {

    private final AnnonceService annonceService;

    public AnnonceRessource(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/add")
    public ResponseEntity<Annonce> save(@RequestBody Annonce annonce){
        return new ResponseEntity<>(annonceService.save(annonce), HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Annonce> getOne(@PathVariable("id") Long id){
        if(existOne(id)){
            return new ResponseEntity<>(annonceService.find(id), HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Annonce>> getAll(){
        return new ResponseEntity<>(annonceService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/auteur/{id}")
    public ResponseEntity<List<Annonce>> getAllfromAuteur(@PathVariable("id") Long idAuteur){
        return new ResponseEntity<>(annonceService.getAllByAuteur(idAuteur), HttpStatus.FOUND);
    }

    /*@GetMapping("/findLocalisation/{localisation}")
    public ResponseEntity<List<Annonce>> getAllfromLocalisation(@PathVariable("localisation") Localisation localisation){
        return new ResponseEntity<>(annonceService.getAllByLocalisation(localisation), HttpStatus.FOUND);
    }*/

    @GetMapping("/prix/{prix}")
    public ResponseEntity<List<Annonce>> getAllByPrixMax(@PathVariable("prix") Long prix){
        return new ResponseEntity<>(annonceService.findAllByPrixMax(prix), HttpStatus.FOUND);
    }

    @GetMapping("/find/{typeLocation}/{prix}")
    public ResponseEntity<List<Annonce>> findAllByTypeLocationAndPrixMax(@PathVariable("typeLocation") String typeLocation, @PathVariable("prix") Long prix){
        return new ResponseEntity<>(annonceService.findAllByTypeLocationAndPrixMax(typeLocation, prix), HttpStatus.FOUND);
    }

    @GetMapping("/objet/{objet}")
    public ResponseEntity<List<Annonce>> findAllByObjet(@PathVariable("objet") String objet){
        return new ResponseEntity<>(annonceService.findAllByObjet(objet), HttpStatus.FOUND);
    }

    @GetMapping("/typeLocation/{typeLocation}")
    public ResponseEntity<List<Annonce>> findAllByTypeLocation(@PathVariable("typeLocation") String typeLocation){
        return new ResponseEntity<>(annonceService.findAllByTypeLocation(typeLocation), HttpStatus.FOUND);
    }

    @GetMapping("/find/{objet}/{typeLocation}/{localisation}/{prix}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}")
    public ResponseEntity<List<Annonce>> findByAllCaracteristiques (String objet, String type, Localisation localisation, Long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return new ResponseEntity<>(
                annonceService
                        .findAllByObjetAndTypeLocationAndLocalisationAndPrixMaxAndNbrChambreAndNbrCUisineAndNbrSalleBain
                        (objet, type, localisation, prix, nbrChambre, nbrCuisine, nbrSalleBain),
                HttpStatus.FOUND
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> update(@PathVariable("id") Long id, @RequestBody Annonce annonce){
        if(existOne(id)){
            return new ResponseEntity<>(annonceService.update(annonce), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public Long count(){
        return annonceService.count();
    }

    /*@GetMapping
    public boolean existByAllCaracteristiques(String objet, String type, Localisation localisation, Long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return annonceService
                .existByObjetAndTypeLocationAndLocalisationAndPrixMaxAndNbrChambreAndNbrCUisineAndNbrSalleBain
                        (objet, type, localisation, prix, nbrChambre, nbrCuisine, nbrSalleBain);
    }*/

    @GetMapping("/exist/{id}")
    public boolean existOne(@PathVariable("id") Long id){
        return annonceService.exist(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        annonceService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        annonceService.deleteAll();
    }

}
