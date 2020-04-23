package com.memoire.wohaya.db;

import com.memoire.wohaya.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> getAllByEtatIgnoreCase(String etat);

}
