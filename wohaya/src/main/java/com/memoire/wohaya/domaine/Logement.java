package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
/*@DiscriminatorColumn(name="type_logement")
@DiscriminatorValue("logement")*/
public class Logement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idLogement;

    @Column(nullable = false)
    protected float prix;

    @ApiModelProperty(notes = "Brève description de l'image")
    protected String description;

    @ApiModelProperty(notes = "Mensuel ou Annuel")
    //mensualités ou annualités
    @Column(nullable = false)
    protected String echeance;

    //sanitaire ou non
    @ApiModelProperty(notes = "sanitaire ou ordinaire")
    @Column(nullable = false)
    protected String confort;

    //location, réservation
    @ApiModelProperty(notes = "location ou réservation")
    @Column(name = "disponibilite", nullable = false, length = 50)
    protected String disponibilite;

    @ApiModelProperty(notes = "Nombre de chambres à coucher")
    @Column(nullable = false)
    protected int nbrChambre;

    @ApiModelProperty(notes = "Nombre de cuisines")
    @Column(nullable = false)
    protected int nbrCuisine;

    @ApiModelProperty(notes = "Nombre de salles de bain")
    @Column(nullable = false)
    protected int nbrSalleBain;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proprietaire")
    protected Proprietaire proprietaire;

    @Embedded
    protected Localisation adresse;

    @JsonIgnore
    @OneToMany(mappedBy = "logement", orphanRemoval = true)
    protected List<ImageLogement> imageLogements = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "logement",orphanRemoval = true)
    protected List<Reservation> reservations;

    @JsonIgnore
    @OneToOne(mappedBy = "logement", orphanRemoval = true)
    protected Publication publications;

}
