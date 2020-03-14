package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur save (Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getOneByTelephoneAndPassword(String telephone, String password) {
        return utilisateurRepository.findByTelephoneAndPassword(telephone, password);
    }

    public List<Utilisateur> getAll(){
        return utilisateurRepository.findAll();
    }

    /*public List<Utilisateur> getAllByRole(String role) {
        return utilisateurRepository.findAllByRole(role);
    }*/
}
