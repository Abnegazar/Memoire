package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.ChambreClassique;
import com.memoire.wohaya.repository.ChambreClassiqueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ChambreClassiqueService {

    private final ChambreClassiqueRepository chambreClassiqueRepository;

    public ChambreClassiqueService(ChambreClassiqueRepository chambreClassiqueRepository) {
        this.chambreClassiqueRepository = chambreClassiqueRepository;
    }

    public ChambreClassique save(ChambreClassique chambreClassique){
        return chambreClassiqueRepository.save(chambreClassique);
    }

    public List<ChambreClassique> getAll(){
        return chambreClassiqueRepository.findAll();
    }

    public ChambreClassique findOne(Long id){
        return chambreClassiqueRepository.getOne(id);
    }

    public ChambreClassique update(ChambreClassique chambreClassique){
        return chambreClassiqueRepository.saveAndFlush(chambreClassique);
    }

    public Boolean existOne(Long id){
        return chambreClassiqueRepository.existsById(id);
    }

    public Long count(){
        return chambreClassiqueRepository.count();
    }

    public void deleteOne(Long id){
        chambreClassiqueRepository.deleteById(id);
    }

    public void deleteAll(){
        chambreClassiqueRepository.deleteAll();
    }

}
