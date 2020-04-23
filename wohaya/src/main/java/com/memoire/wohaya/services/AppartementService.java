package com.memoire.wohaya.services;

import com.memoire.wohaya.model.Appartement;
import com.memoire.wohaya.db.AppartementRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AppartementService {

    private final AppartementRepository appartementRepository;

    public AppartementService(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
    }

    public Appartement save(Appartement appartement){
        return appartementRepository.save(appartement);
    }

    public List<Appartement> getPrix(float prix){
        return appartementRepository.findAllByPrixLessThanEqual(prix);
    }

    public List<Appartement> getPrixMeuble(float prix, boolean meubler){
        return appartementRepository.findAllByPrixLessThanEqualAndMeubler(prix, meubler);
    }

    public List<Appartement> findAllByDisponibiliteAndPrix(String disponibilite, float prix){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqual(disponibilite, prix);
    }

    public List<Appartement> getDispoPrixMeuble(String dispo, float prix, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndMeubler(dispo, prix, meubler);
    }

    public List<Appartement> getDispoPrixEcheance(String dispo, float prix, String echeance){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCase(dispo, prix, echeance);
    }

    public List<Appartement> getDispoPrixEcheanceMeuble(String dispo, float prix, String echeance, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndMeubler(dispo, prix, echeance, meubler);
    }

    public List<Appartement> getDispoPrixConfort(String dispo, float prix, String confort){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCase(dispo, prix, confort);
    }

    public List<Appartement> getDispoPrixConfortMeuble(String dispo, float prix, String confort, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndMeubler(dispo, prix, confort, meubler);
    }

    public List<Appartement> getDispoPrixEcheanceConfort(String dispo, float prix, String echeance, String confort){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCase(dispo, prix, echeance, confort);
    }

    public List<Appartement> getDispoPrixEcheanceConfortMeuble(String dispo, float prix, String echeance, String confort, boolean meuble){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndMeubler(dispo, prix, echeance, confort, meuble);
    }

    public List<Appartement> getDispoPrixConfortNbr_Chambr_cuisine_bain(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, confort, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Appartement> getDispoPrixConfortNbr_Chambr_cuisine_bainMeubler(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(disponibilite, prix, confort, nbrChambre, nbrCuisine, nbrSalleBain, meubler);
    }

    public List<Appartement> getDispoPrixConfortEcheanceNbr_Chambr_cuisine_bain(String disponibilite, float prix, String confort, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, confort, echeance, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Appartement> getDispoPrixConfortEcheanceNbr_Chambr_cuisine_bainMeubler(String disponibilite, float prix, String confort, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(disponibilite, prix, confort, echeance, nbrChambre, nbrCuisine, nbrSalleBain, meubler);
    }

    public List<Appartement> getAll(){
        return appartementRepository.findAll();
    }

    public boolean existById(Long id){
        return appartementRepository.existsById(id);
    }

    public Long countAll (){
        return appartementRepository.count();
    }

    public Appartement update(Appartement appartement){
        return appartementRepository.saveAndFlush(appartement);
    }

    public void deleteOne(Long id){
        appartementRepository.deleteById(id);
    }

    public void deleteAll(){
        appartementRepository.deleteAll();
    }

}