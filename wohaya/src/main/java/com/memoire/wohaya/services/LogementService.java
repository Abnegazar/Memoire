package com.memoire.wohaya.services;

import com.memoire.wohaya.model.Logement;
import com.memoire.wohaya.db.LogementRepository;
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

    public List<Logement> getDispoPrixConfort(String dispo, float prix, String confort){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCase(dispo, prix, confort);
    }

    public List<Logement> getDispoPrixEcheanceConfort(String dispo, float prix, String echeance, String confort){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCase(dispo, prix, echeance, confort);
    }

    public List<Logement> getDispoPrixConfortNbr_Chambr_cuisine_bain(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, confort, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Logement> getDispoPrixConfortEcheanceNbr_Chambr_cuisine_bain(String disponibilite, float prix, String confort, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return logementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, confort, echeance, nbrChambre, nbrCuisine, nbrSalleBain);
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
