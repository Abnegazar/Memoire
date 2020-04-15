package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wohaya-api/utilisateur")
public class UtilisateurRessource {

    private final UtilisateurService utilisateurService;

    public UtilisateurRessource(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Utilisateur> save(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(utilisateurService.save(utilisateur), HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{telephone}/{password}")
    public ResponseEntity<Utilisateur> findOneByTelephoneAndPassword(@PathVariable("telephone") String telephone, @PathVariable("password") String password){
        return new ResponseEntity<>(utilisateurService.getOneByTelephoneAndPassword(telephone, password), HttpStatus.FOUND);
    }

    @GetMapping(value = "/find/{telephone}")
    public ResponseEntity<Utilisateur> findOneByTelephone(@PathVariable("telephone") String telephone){
        return new ResponseEntity<>(utilisateurService.getOneByTelephone(telephone), HttpStatus.FOUND);
    }

    @GetMapping(value = "/find_all")
    public ResponseEntity<List<Utilisateur>> getAll(){
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping(value = "exist/{phone}/{pwd}")
    public boolean existUser(@PathVariable("phone") String phone, @PathVariable("pwd") String pwd){
        return utilisateurService.existByPhoneAndPwd(phone, pwd);
    }

    @PutMapping(value = "/{phone}/{pwd}")
    public ResponseEntity<Utilisateur> changeUser(Utilisateur utilisateur, @PathVariable("phone") String phone, @PathVariable("pwd") String pwd){
        if(existUser(phone, pwd)){
            return new ResponseEntity<>(utilisateurService.updateUser(utilisateur), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public Long count(){
        return utilisateurService.count();
    }

    @DeleteMapping(value = "/{phone}/{pwd}")
    public void deleteUser(@PathVariable("phone") String phone, @PathVariable("pwd") String pwd){
        if(existUser(phone, pwd)){
            utilisateurService.deleteOne(phone, pwd);
        }else{
            System.out.println("Cet utilisateur n'existe pas.");
        }
    }

    @DeleteMapping(value = "/delete_all")
    public void deleteAll(){
        utilisateurService.deleteAll();
    }

    /*@GetMapping(value = "/find_all/{role}")
    public ResponseEntity<List<Utilisateur>> findAllByRole(@PathVariable("role") String role){
        return new ResponseEntity<>(utilisateurService.getAllByRole(role), HttpStatus.FOUND);
    }*/

}
