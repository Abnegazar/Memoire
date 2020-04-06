package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Abonnement;
import com.memoire.wohaya.repository.AbonnementRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AbonnementService {

    private final AbonnementRepository abonnementRepository;

    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    public Abonnement save(Abonnement abonnement){
        return abonnementRepository.save(abonnement);
    }

    public Abonnement getOne(Long id){
        return abonnementRepository.getByIdAbonnement(id);
    }

    public List<Abonnement> getMany(int nbrAppart, int nbrChambre, int nbrResidence){
        return abonnementRepository.getAllByNbrAppartGreaterThanEqualAndNbrChambreGreaterThanEqualAndNbrResidenceGreaterThanEqual(nbrAppart, nbrChambre, nbrResidence);
    }

    public List<Abonnement> getByDuree(int duree){
        return abonnementRepository.getByDuree(duree);
    }

    public List<Abonnement> getByMontant(Long montant){
        return abonnementRepository.getAllByMontantLessThanEqual(montant);
    }

    public List<Abonnement> getAll(){
        return abonnementRepository.findAll();
    }

    public Abonnement update(Abonnement abonnement){
        return abonnementRepository.saveAndFlush(abonnement);
    }

    public boolean existOne(Long idAbonnement){
        return abonnementRepository.existsById(idAbonnement);
    }

    public boolean existByMontant(Long montant){
        return abonnementRepository.existsByMontantLessThanEqual(montant);
    }

    public long count_all(){
        return abonnementRepository.count();
    }

    public void delete_all(){
        abonnementRepository.deleteAll();
    }

}
