package com.memoire.wohaya.db;

import com.memoire.wohaya.model.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

    @Nullable
    List<Abonnement> getByDuree(int duree);

    @Nullable
    Abonnement getByIdAbonnement(Long id);

    @Nullable
    List<Abonnement> getAllByNbrAppartGreaterThanEqualAndNbrChambreGreaterThanEqualAndNbrResidenceGreaterThanEqual(int nbrAppart, int nbrChambre, int nbrResidence);

    @Nullable
    List<Abonnement> getAllByMontantLessThanEqual(Long montant);

    boolean existsByMontantLessThanEqual(long montant);

}
