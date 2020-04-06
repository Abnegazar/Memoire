package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AppartementRepository extends JpaRepository<Appartement, Long> {

    @Nullable
    List<Appartement> findAllByPrixLessThanEqual(float prix);

    @Nullable
    List<Appartement> findAllByPrixLessThanEqualAndMeubler(float prix, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqual(String disponibilite, float prix);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndMeubler(String disponibilite, float prix, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCase(String disponibilite, float prix, String echeance);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndMeubler(String disponibilite, float prix, String echeance, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCase(String disponibilite, float prix, String categorie);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndMeubler(String disponibilite, float prix, String categorie, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCase(String disponibilite, float prix, String echeance, String categorie);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndMeubler(String disponibilite, float prix, String echeance, String categorie, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String echeance, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(String disponibilite, float prix, String echeance, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler);


}
