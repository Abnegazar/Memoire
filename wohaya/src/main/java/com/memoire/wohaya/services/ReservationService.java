package com.memoire.wohaya.services;

import com.memoire.wohaya.model.Reservation;
import com.memoire.wohaya.db.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public List<Reservation> getAllByEtat(String etat){
        return reservationRepository.getAllByEtatIgnoreCase(etat);
    }

    public Reservation findOne(Long id){
        return reservationRepository.getOne(id);
    }

    public Reservation update(Reservation reservation){
        return reservationRepository.saveAndFlush(reservation);
    }

    public Boolean existOne(Long id){
        return reservationRepository.existsById(id);
    }

    public Long count(){
        return reservationRepository.count();
    }

    public void deleteOne(Long id){
        reservationRepository.deleteById(id);
    }

    public void deleteAll(){
        reservationRepository.deleteAll();
    }

}
