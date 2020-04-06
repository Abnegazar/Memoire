package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Appartement;
import com.memoire.wohaya.repository.AppartementRepository;
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

    public List<Appartement> getDispoPrixCategorie(String dispo, float prix, String categorie){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCase(dispo, prix, categorie);
    }

    public List<Appartement> getDispoPrixCategorieMeuble(String dispo, float prix, String categorie, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndMeubler(dispo, prix, categorie, meubler);
    }

    public List<Appartement> getDispoPrixEcheanceCategorie(String dispo, float prix, String echeance, String categorie){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCase(dispo, prix, echeance, categorie);
    }

    public List<Appartement> getDispoPrixEcheanceCategorieMeuble(String dispo, float prix, String echeance, String categorie, boolean meuble){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndMeubler(dispo, prix, echeance, categorie, meuble);
    }

    public List<Appartement> getDispoPrixCategorieNbr_Chambr_cuisine_bain(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Appartement> getDispoPrixCategorieNbr_Chambr_cuisine_bainMeubler(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(disponibilite, prix, categorie, nbrChambre, nbrCuisine, nbrSalleBain, meubler);
    }

    public List<Appartement> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bain(String disponibilite, float prix, String categorie, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain);
    }

    public List<Appartement> getDispoPrixCategorieEcheanceNbr_Chambr_cuisine_bainMeubler(String disponibilite, float prix, String categorie, String echeance, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler){
        return appartementRepository.findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(disponibilite, prix, categorie, echeance, nbrChambre, nbrCuisine, nbrSalleBain, meubler);
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