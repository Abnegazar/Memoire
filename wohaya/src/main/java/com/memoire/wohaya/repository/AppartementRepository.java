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
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCase(String disponibilite, float prix, String confort);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndMeubler(String disponibilite, float prix, String confort, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCase(String disponibilite, float prix, String echeance, String confort);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndMeubler(String disponibilite, float prix, String echeance, String confort, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(String disponibilite, float prix, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqual(String disponibilite, float prix, String echeance, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    @Nullable
    List<Appartement> findAllByDisponibiliteIgnoreCaseAndPrixLessThanEqualAndEcheanceIgnoreCaseAndConfortIgnoreCaseAndNbrChambreGreaterThanEqualAndNbrCuisineGreaterThanEqualAndNbrSalleBainGreaterThanEqualAndMeubler(String disponibilite, float prix, String echeance, String confort, int nbrChambre, int nbrCuisine, int nbrSalleBain, boolean meubler);


}
