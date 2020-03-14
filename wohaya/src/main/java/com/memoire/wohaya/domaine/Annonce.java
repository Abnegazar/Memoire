package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;

    //Choisir entre annonce pour réservation ou pour location
    @Column(nullable = false)
    private String objet;

    @Column(nullable = false, name = "date_annonce")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateAnnonce = LocalDate.now();

    //facultatif
    private float prixMax;

    @Column(nullable = false)
    private int nbrChambre;

    @Column(nullable = false)
    private int nbrSalleBain;

    @Column(nullable = false)
    private int nbrCUisine;

    @Column(nullable = false)
    private String typeLocation;

    @Embedded
    private Localisation localisation;

    @OneToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

}
