package com.memoire.wohaya.controller;

import com.memoire.wohaya.model.Reservation;
import com.memoire.wohaya.services.ReservationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequestMapping("/wohaya-api/reservation")
@RestController
@Api(value="Gestion des Réservations")
public class ReservationRessource {

    private final ReservationService reservationService;

    public ReservationRessource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation){
        if(reservation.getDateReservation() == null){
            reservation.setDateReservation(LocalDate.now(ZoneId.of("Africa/Porto-Novo")));
        }
        return new ResponseEntity<>(reservationService.save(reservation), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Reservation>> getAll(){
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(reservationService.findOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/{etat}")
    public ResponseEntity<List<Reservation>> getAllByEtat(@PathVariable("etat") String etat){
        return new ResponseEntity<>(reservationService.getAllByEtat(etat), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable("id") Long id, @RequestBody Reservation reservation){
        if (existId(id)){
            return new ResponseEntity<>(reservationService.update(reservation), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return reservationService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return reservationService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        reservationService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        reservationService.deleteAll();
    }

}
