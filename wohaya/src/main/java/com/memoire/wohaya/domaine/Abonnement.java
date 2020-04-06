package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbonnement;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false)
    private Float montant;

    @Column(name = "nbr_chambre", nullable = false)
    private int nbrChambre;

    @Column(name = "nbr_residence", nullable = false)
    private int nbrResidence;

    @Column(name = "nbr_appart", nullable = false)
    private int nbrAppart;

    @JsonIgnore
    @OneToMany(mappedBy = "abonnement")
    private List<Proprietaire> proprietaires = new ArrayList<>();

}
