package com.memoire.wohaya.domaine;

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
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;

    //Choisir entre annonce pour réservation ou pour location
    @ApiModelProperty(notes = "Pour réservation ou location ?")
    @Column(nullable = false)
    private String objet;

    @Column(nullable = false, name = "date_annonce")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateAnnonce = LocalDate.now();

    //facultatif
    @ApiModelProperty(notes = "prix maximal du logement recherché.")
    private Float prixMax;

    @ApiModelProperty(notes = "Nombre de chambres désiré.")
    @Column(nullable = false)
    private int nbrChambre;

    @ApiModelProperty(notes = "Nombre de salles de bains demandé.")
    @Column(nullable = false)
    private int nbrSalleBain;

    @ApiModelProperty(notes = "Nombre de Cuisine siuhaité.")
    @Column(nullable = false)
    private int nbrCuisine;

    @ApiModelProperty(notes = "Type préféré : Chambre classique, Résidence ou Appartement.")
    @Column(nullable = false)
    private String typeLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zone", column = @Column(name = "localisation_zone"))
    })
    private Localisation localisation;

    @ManyToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

}
