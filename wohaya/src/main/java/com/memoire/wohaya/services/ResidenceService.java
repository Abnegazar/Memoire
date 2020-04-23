package com.memoire.wohaya.services;

import com.memoire.wohaya.model.Residence;
import com.memoire.wohaya.db.ResidenceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResidenceService {

    private final ResidenceRepository residenceRepository;

    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }

    public Residence save(Residence residence){
        return residenceRepository.save(residence);
    }

    public List<Residence> getAll(){
        return residenceRepository.findAll();
    }

    public Residence findOne(Long id){
        return residenceRepository.getOne(id);
    }

    public Residence update(Residence residence){
        return residenceRepository.saveAndFlush(residence);
    }

    public Boolean existOne(Long id){
        return residenceRepository.existsById(id);
    }

    public Long count(){
        return residenceRepository.count();
    }

    public void deleteOne(Long id){
        residenceRepository.deleteById(id);
    }

    public void deleteAll(){
        residenceRepository.deleteAll();
    }

}
