/*
package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Appreciation;
import com.memoire.wohaya.domaine.Publication;
import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.repository.AppreciationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AppreciationService {

    private final AppreciationRepository appreciationRepository;

    public AppreciationService(AppreciationRepository appreciationRepository) {
        this.appreciationRepository = appreciationRepository;
    }

    public Appreciation save(Appreciation appreciation){
        return appreciationRepository.save(appreciation);
    }

    public Appreciation getOne (Utilisateur auteur, Publication publication){
        return appreciationRepository.findByAuteurAndPublication(auteur, publication);
    }

    public List<Appreciation> getAll(){
        return appreciationRepository.findAll();
    }

    public Long count(){
        return appreciationRepository.count();
    }

    public boolean exiistOne(Utilisateur auteur, Publication publication){
        return appreciationRepository.existByAuteurAndPublication(auteur, publication);
    }

    public Appreciation update(Appreciation appreciation){
        return appreciationRepository.saveAndFlush(appreciation);
    }

    public void deleteAll(){
        appreciationRepository.deleteAll();
    }

}
*/
