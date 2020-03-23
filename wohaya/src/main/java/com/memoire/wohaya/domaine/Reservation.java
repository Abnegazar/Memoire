package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false, name = "date_debut")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateDebut;

    @Column(nullable = false, name = "date_fin")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateFin;

    @Column(nullable = false, name = "date_reservation")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateReservation;

    @Column(nullable = false)
    private String etat;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "logement")
    private Logement logement;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

}
