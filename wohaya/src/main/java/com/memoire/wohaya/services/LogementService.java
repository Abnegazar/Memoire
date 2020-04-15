package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Logement;
import com.memoire.wohaya.repository.LogementRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LogementService {

    private final LogementRepository logementRepository;

    public LogementService(LogementRepository logementRepository) {
        this.logementRepository = logementRepository;
    }

    public Logement save(Logement logement){
        return logementRepository.save(logement);
    }

    public List<Logement> getPrix(float prix){
        return logementRepository.findAllByPrixLessThanEqual(prix);
    }

    public List<Logement> findAllByDisponibiliteAndPrix(String disponibilite, float prix){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqual(disponibilite, prix);
    }

    public List<Logement> getDispoPrix(String dispo, float prix){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqual(dispo, prix);
    }

    public List<Logement> getDispoPrixEcheance(String dispo, float prix, String echeance){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCase(dispo, prix, echeance);
    }

    public List<Logement> getDispoPrixCategorie(String dispo, float prix, String categorie){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCase(dispo, prix, categorie);
    }

    public List<Logement> getDispoPrixEcheanceCategorie(String dispo, float prix, String echeance, String categorie){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCase(dispo, prix, echeance, categorie);
    }

    public List<Logement> getDispoPrixCategorieNbr_Chambr_cuisine_bain(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Logement> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain(String disponibilite, float prix, String categorie, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Logement> getAll(){
        return logementRepository.findAll();
    }

    public boolean existById(Long id){
        return logementRepository.existsById(id);
    }

    public Long countAll (){
        return logementRepository.count();
    }

    public Logement update(Logement logement){
        return logementRepository.saveAndFlush(logement);
    }

    public void deleteOne(Long id){
        logementRepository.deleteById(id);
    }

    public void deleteAll(){
        logementRepository.deleteAll();
    }

}
