package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Logement;
import com.memoire.wohaya.services.LogementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/wohaya-api/logement")
@RestController
public class LogementRessource {

    private final LogementService logementService;

    public LogementRessource(LogementService logementService) {
        this.logementService = logementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Logement> save(@RequestBody Logement logement){
        return new ResponseEntity<>(logementService.save(logement), HttpStatus.CREATED);
    }

    @GetMapping("/prix/{prix}")
    public ResponseEntity<List<Logement>> getByPrix(@PathVariable("prix") float prix){
        return new ResponseEntity<>(logementService.getPrix(prix), HttpStatus.FOUND);
    }

    @GetMapping("/findPriMeu/{prix}/{meubler}")
    public ResponseEntity<List<Logement>> getByPrixAnd
            (@PathVariable("prix") float prix){
        return new ResponseEntity<>(logementService.getPrix(prix), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPri/{disponibilite}/{prix}")
    public ResponseEntity<List<Logement>> getAllByDisponibiliteAndPrix
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix){
        return new ResponseEntity<>(logementService.findAllByDisponibiliteAndPrix(disponibilite, prix), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriMeu/{disponibilite}/{prix}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrix
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix){
        return new ResponseEntity<>(logementService.getDispoPrix(disponibilite, prix), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEchMeu/{disponibilite}/{prix}/{echeance}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrixEcheance
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance){
        return new ResponseEntity<>(logementService.getDispoPrixEcheance(disponibilite, prix, echeance), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatMeu/{disponibilite}/{prix}/{categorie}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrixCategorie
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie){
        return new ResponseEntity<>(logementService.getDispoPrixCategorie(disponibilite, prix, categorie), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEchCatMeu/{disponibilite}/{prix}/{echeance}/{categorie}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrixEcheanceCategorie
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance, @PathVariable("categorie") String categorie){
        return new ResponseEntity<>(logementService.getDispoPrixEcheanceCategorie(disponibilite, prix, echeance, categorie), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatNbrChamCuiBainMeu/{disponibilite}/{prix}/{categorie}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrixCategorieNbr_Chambr_cuisine_bain
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain){
        return new ResponseEntity<>(logementService.getDispoPrixCategorieNbr_Chambr_cuisine_bain(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatEchNbrChamCuiBainMeu/{disponibilite}/{prix}/{categorie}/{echeance}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}/{meubler}")
    public ResponseEntity<List<Logement>> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("echeance") String echeance, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain){
        return new ResponseEntity<>(logementService.getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain), HttpStatus.FOUND);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Logement>> getAll(){
        return new ResponseEntity<>(logementService.getAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logement> update(@RequestBody Logement logement, @PathVariable("id") Long id){
        if(existById(id)){
            return new ResponseEntity<>(logementService.update(logement), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("exist/{id}")
    public boolean existById(@PathVariable("id") Long id){
        return logementService.existById(id);
    }

    @GetMapping("/count")
    public Long count(){
        return logementService.countAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        logementService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        logementService.deleteAll();
    }

}
