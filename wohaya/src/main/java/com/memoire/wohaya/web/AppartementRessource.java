package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Appartement;
import com.memoire.wohaya.services.AppartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wohaya-api/appart")
public class AppartementRessource {

    private final AppartementService appartementService;

    public AppartementRessource(AppartementService appartementService) {
        this.appartementService = appartementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Appartement> save(@RequestBody Appartement appartement){
        return new ResponseEntity<>(appartementService.save(appartement), HttpStatus.CREATED);
    }

    @GetMapping("/prix/{prix}")
    public ResponseEntity<List<Appartement>> getByPrix(@PathVariable("prix") float prix){
        return new ResponseEntity<>(appartementService.getPrix(prix), HttpStatus.FOUND);
    }

    @GetMapping("/findPriMeu/{prix}/{meubler}")
    public ResponseEntity<List<Appartement>> getByPrixAndMeuble
            (@PathVariable("prix") float prix, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getPrixMeuble(prix, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPri/{disponibilite}/{prix}")
    public ResponseEntity<List<Appartement>> getAllByDisponibiliteAndPrix
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix){
        return new ResponseEntity<>(appartementService.findAllByDisponibiliteAndPrix(disponibilite, prix), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriMeu/{disponibilite}/{prix}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixMeuble
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixMeuble(disponibilite, prix, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEch/{disponibilite}/{prix}/{echeance}")
    public ResponseEntity<List<Appartement>> getDispoPrixEcheance
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance){
        return new ResponseEntity<>(appartementService.getDispoPrixEcheance(disponibilite, prix, echeance), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEchMeu/{disponibilite}/{prix}/{echeance}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixEcheanceMeuble
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixEcheanceMeuble(disponibilite, prix, echeance, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCat/{disponibilite}/{prix}/{categorie}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorie
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorie(disponibilite, prix, categorie), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatMeu/{disponibilite}/{prix}/{categorie}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorieMeuble
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorieMeuble(disponibilite, prix, categorie, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEchCat/{disponibilite}/{prix}/{echeance}/{categorie}")
    public ResponseEntity<List<Appartement>> getDispoPrixEcheanceCategorie
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance, @PathVariable("categorie") String categorie){
        return new ResponseEntity<>(appartementService.getDispoPrixEcheanceCategorie(disponibilite, prix, echeance, categorie), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriEchCatMeu/{disponibilite}/{prix}/{echeance}/{categorie}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixEcheanceCategorieMeuble
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("echeance") String echeance, @PathVariable("categorie") String categorie, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixEcheanceCategorieMeuble(disponibilite, prix, echeance, categorie, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatNbrChamCuiBain/{disponibilite}/{prix}/{categorie}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorieNbr_Chambr_cuisine_bain
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorieNbr_Chambr_cuisine_bain(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatNbrChamCuiBainMeu/{disponibilite}/{prix}/{categorie}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorieNbr_Chambr_cuisine_bainMeubler
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorieNbr_Chambr_cuisine_bainMeubler(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatEchNbrChamCuiBain/{disponibilite}/{prix}/{categorie}/{echeance}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("echeance") String echeance, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain), HttpStatus.FOUND);
    }

    @GetMapping("/findDisPriCatEchNbrChamCuiBainMeu/{disponibilite}/{prix}/{categorie}/{echeance}/{nbrChambre}/{nbrCuisine}/{nbrSalleBain}/{meubler}")
    public ResponseEntity<List<Appartement>> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bainMeubler
            (@PathVariable("disponibilite") String disponibilite, @PathVariable("prix") float prix, @PathVariable("categorie") String categorie, @PathVariable("echeance") String echeance, @PathVariable("nbrChambre") int nbrChambre, @PathVariable("nbrCuisine") int nbrCuisine, @PathVariable("nbrSalleBain") int nbrSalleBain, @PathVariable("meubler") boolean meubler){
        return new ResponseEntity<>(appartementService.getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bainMeubler(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain, meubler), HttpStatus.FOUND);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Appartement>> getAll(){
        return new ResponseEntity<>(appartementService.getAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appartement> update(@RequestBody Appartement appartement, @PathVariable("id") Long id){
        if(existById(id)){
            return new ResponseEntity<>(appartementService.update(appartement), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("exist/{id}")
    public boolean existById(@PathVariable("id") Long id){
        return appartementService.existById(id);
    }

    @GetMapping("/count")
    public Long count(){
        return appartementService.countAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        appartementService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        appartementService.deleteAll();
    }

}
