package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> getAllByEtatIgnoreCase(String etat);

}
