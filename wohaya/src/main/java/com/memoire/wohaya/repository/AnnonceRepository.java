package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Annonce;
import com.memoire.wohaya.domaine.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    @Nullable
   // @Query("select a from annonce as a, utilisateur as ut where a.auteur.idUtilisateur =  ut.idUtilisateur and a.auteur.idUtilisateur = ?1")
    List<Annonce> getAllByAuteur(Long idAuteur);

    Annonce findByIdAnnonce(Long id);

    @Nullable
    List<Annonce> getAllByLocalisation(Localisation localisation);

    @Nullable
    List<Annonce> findAllByPrixMaxLessThanEqual(Long prix);

    @Nullable
    List<Annonce> findAllByTypeLocationIgnoreCaseAndPrixMaxLessThanEqual(String type, Long prix);

    @Nullable
    List<Annonce> findAllByObjetIgnoreCase(String objet);


    @Nullable
    List<Annonce> findAllByTypeLocationIgnoreCase(String type);

    @Nullable
    List<Annonce> findAllByObjetIgnoreCaseAndTypeLocationAndLocalisationAndPrixMaxLessThanEqualAndNbrChambreLessThanEqualAndNbrCuisineLessThanEqualAndNbrSalleBainLessThanEqual(String objet, String type, Localisation localisation, long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    //public boolean existAllByObjetAndTypeLocationAndLocalisationAndPrixMaxGreaterThanEqualAndNbrChambreLessThanEqualAndNbrCUisineLessThanEqualAndNbrSalleBainLessThanEqual(String objet, String type, Localisation localisation, long prix, int nbrChambre, int nbrCuisine, int nbrSalleBain);

    void deleteByIdAnnonce(Long id);

}
