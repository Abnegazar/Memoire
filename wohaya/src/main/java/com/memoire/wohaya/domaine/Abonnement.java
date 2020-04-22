package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

    @ApiModelProperty(notes = "Durée de l'abonnement en mois")
    @Column(nullable = false)
    private int duree;

    @ApiModelProperty(notes = "Montant de l'abonnement")
    @Column(nullable = false)
    private Float montant;

    @ApiModelProperty(notes = "Nombre de chambre accordé.")
    @Column(name = "nbr_chambre", nullable = false)
    private int nbrChambre;

    @ApiModelProperty(notes = "Nombre de résidences accordé.")
    @Column(name = "nbr_residence", nullable = false)
    private int nbrResidence;

    @ApiModelProperty(notes = "Nombre d'appartement accordé.")
    @Column(name = "nbr_appart", nullable = false)
    private int nbrAppart;

    public Abonnement(int duree, float montant, int nbrAppart, int nbrChambre, int nbrResidence){
        this.duree = duree;
        this.montant = montant;
        this.nbrAppart = nbrAppart;
        this.nbrChambre = nbrChambre;
        this.nbrResidence = nbrResidence;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "abonnement")
    private List<Proprietaire> proprietaires = new ArrayList<>();

}
