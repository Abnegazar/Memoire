package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.PrendreContact;
import com.memoire.wohaya.repository.PrendreContactRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrendreContactService {

    private final PrendreContactRepository prendreContactRepository;

    public PrendreContactService(PrendreContactRepository prendreContactRepository) {
        this.prendreContactRepository = prendreContactRepository;
    }

    public PrendreContact save(PrendreContact prendreContact){
        return prendreContactRepository.save(prendreContact);
    }

    public List<PrendreContact> getAll(){
        return prendreContactRepository.findAll();
    }

    public PrendreContact findOne(Long id){
        return prendreContactRepository.getOne(id);
    }

    public PrendreContact update(PrendreContact prendreContact){
        return prendreContactRepository.saveAndFlush(prendreContact);
    }

    public Boolean existOne(Long id){
        return prendreContactRepository.existsById(id);
    }

    public Long count(){
        return prendreContactRepository.count();
    }

    public void deleteOne(Long id){
        prendreContactRepository.deleteById(id);
    }

    public void deleteAll(){
        prendreContactRepository.deleteAll();
    }

}
