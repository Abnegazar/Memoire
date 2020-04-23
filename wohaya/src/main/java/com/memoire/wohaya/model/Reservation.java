package com.memoire.wohaya.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(notes = "Date de début de la réservation")
    @Column(nullable = false, name = "date_debut")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateDebut;

    @Column(nullable = false, name = "date_fin")
    @ApiModelProperty(notes = "Date de fin de la réservation")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateFin;

    @Column(nullable = false, name = "date_reservation")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateReservation;

    @ApiModelProperty(notes = "acceptée ou rejetée")
    @Column(nullable = false)
    private String etat;

    @ManyToOne
    @JoinColumn(name = "logement")
    private Logement logement;

    @ManyToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

}
