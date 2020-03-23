package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Annonce;
import com.memoire.wohaya.domaine.Localisation;
import com.memoire.wohaya.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce save(Annonce annonce){
        return annonceRepository.save(annonce);
    }

    public Annonce find(Long id){
        return annonceRepository.findByIdAnnonce(id);
    }

    public List<Annonce> findAll(){
        return annonceRepository.findAll();
    }

    public List<Annonce> getAllByAuteur(Long idAuteur){
        return annonceRepository.getAllByAuteur(idAuteur);
    }

    public List<Annonce> getAllByLocalisation(Localisation localisation){
        return annonceRepository.getAllByLocalisation(localisation);
    }

    public List<Annonce> findAllByPrixMax(Long prix){
        return annonceRepository.findAllByPrixMaxLessThanEqual(prix);
    }

    public List<Annonce> findAllByTypeLocationAndPrixMax(String type, Long prix){
        return annonceRepository.findAllByTypeLocationIgnoreCaseAndPrixMaxLessThanEqual(type, prix);
    }

    public List<Annonce> findAllByObjet(String objet){
        return annonceRepository.findAllByObjetIgnoreCase(objet);
    }

    public List<Annonce> findAllByTypeLocation(String type){
        return annonceRepository.findAllByTypeLocationIgnoreCase(type);
    }

    public List<Annonce> findAllByObjetAndTypeLocationAndLocalisationAndPrixMaxAndNbrChambreAndNbrCUisineAndNbrSalleBain
            (String objet, String type, Localisation localisation, Long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return annonceRepository
                .findAllByObjetIgnoreCaseAndTypeLocationAndLocalisationAndPrixMaxLessThanEqualAndNbrChambreLessThanEqualAndNbrCuisineLessThanEqualAndNbrSalleBainLessThanEqual
                        (objet, type, localisation, prix, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public Annonce update(Annonce annonce){
        return annonceRepository.saveAndFlush(annonce);
    }

    public Long count(){
        return annonceRepository.count();
    }

    /*public boolean existByObjetAndTypeLocationAndLocalisationAndPrixMaxAndNbrChambreAndNbrCUisineAndNbrSalleBain
            (String objet, String type, Localisation localisation, Long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return annonceRepository
                .existAllByObjetAndTypeLocationAndLocalisationAndPrixMaxGreaterThanEqualAndNbrChambreLessThanEqualAndNbrCUisineLessThanEqualAndNbrSalleBainLessThanEqual
                        (objet, type, localisation, prix, nbrChambre, nbrCuisine, nbrSalleBain);
    }*/

    public boolean exist(Long id)    {
        return annonceRepository.existsById(id);
    }

    public void deleteOne(Long id){
        annonceRepository.deleteById(id);
    }

    public void deleteAll(){
        annonceRepository.deleteAll();
    }

}
