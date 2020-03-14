package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurRessource {

    private final UtilisateurService utilisateurService;

    public UtilisateurRessource(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Utilisateur> save(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(utilisateurService.save(utilisateur), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{telephone}/{password}")
    public ResponseEntity<Utilisateur> findOneByTelephoneAndPassword(@PathVariable("telephone") String telephone, @PathVariable("password") String password){
        return new ResponseEntity<>(utilisateurService.getOneByTelephoneAndPassword(telephone, password), HttpStatus.FOUND);
    }

    @GetMapping(value = "/find_all")
    public ResponseEntity<List<Utilisateur>> getAll(){
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.FOUND);
    }

    /*@GetMapping(value = "/find_all/{role}")
    public ResponseEntity<List<Utilisateur>> findAllByRole(@PathVariable("role") String role){
        return new ResponseEntity<>(utilisateurService.getAllByRole(role), HttpStatus.FOUND);
    }*/

}
