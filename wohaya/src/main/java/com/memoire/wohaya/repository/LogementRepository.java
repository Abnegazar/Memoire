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
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCase(String disponibilite, float prix, String confort);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCase(String disponibilite, float prix, String echeance, String confort);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Logement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String echeance, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain);



}
