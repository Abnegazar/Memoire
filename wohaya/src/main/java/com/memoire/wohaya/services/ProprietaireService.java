package com.memoire.wohaya.services;

import com.memoire.wohaya.model.Proprietaire;
import com.memoire.wohaya.db.ProprietaireRepository;
import com.memoire.wohaya.db.UtilisateurRepository;
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

    public Proprietaire findOne(Long id){
        return proprietaireRepository.getOne(id);
    }

    public Proprietaire update(Proprietaire proprietaire){
        return proprietaireRepository.saveAndFlush(proprietaire);
    }

    public Boolean existOne(Long id){
        return proprietaireRepository.existsById(id);
    }

    public Long count(){
        return proprietaireRepository.count();
    }

    public void deleteOne(Long id){
        proprietaireRepository.deleteById(id);
    }

    public void deleteAll(){
        proprietaireRepository.deleteAll();
    }

}
