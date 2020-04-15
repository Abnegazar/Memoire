package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface LogementRepository extends JpaRepository<Logement, Long> {


    @Nullable
    List<Logement> findAllByPrixLessThanEqual(float prix);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqual(String disponibilite, float prix);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCase(String disponibilite, float prix, String echeance);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCase(String disponibilite, float prix, String categorie);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCase(String disponibilite, float prix, String echeance, String categorie);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndCategorieIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String echeance, String categorie, int nbrChambre, int nbrCuisine, int nbrSalleBain);



}
