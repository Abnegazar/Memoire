package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Proprietaire;
import com.memoire.wohaya.repository.ProprietaireRepository;
import com.memoire.wohaya.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProprietaireService {

    private final ProprietaireRepository proprietaireRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ProprietaireService(ProprietaireRepository proprietaireRepository, UtilisateurRepository utilisateurRepository) {
        this.proprietaireRepository = proprietaireRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public Proprietaire save(Proprietaire proprietaire){
        return utilisateurRepository.save(proprietaire);
    }

    public List<Proprietaire> getAll(){
        return proprietaireRepository.findAll();
    }

}
