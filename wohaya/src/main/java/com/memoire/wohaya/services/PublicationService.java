package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Publication;
import com.memoire.wohaya.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublicationService {

    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication save(Publication publication){
        return publicationRepository.save(publication);
    }

    public List<Publication> getAll(){
        return publicationRepository.findAll();
    }

    public List<Publication> getAllByStatus(String status){
        return publicationRepository.getAllByStatusIgnoreCase(status);
    }

    public Publication findOne(Long id){
        return publicationRepository.getOne(id);
    }

    public Publication update(Publication publication){
        return publicationRepository.saveAndFlush(publication);
    }

    public Boolean existOne(Long id){
        return publicationRepository.existsById(id);
    }

    public Long count(){
        return publicationRepository.count();
    }

    public void deleteOne(Long id){
        publicationRepository.deleteById(id);
    }

    public void deleteAll(){
        publicationRepository.deleteAll();
    }

}
