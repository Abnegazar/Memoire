package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    protected String description;

    //mensualités ou annualités
    @Column(nullable = false)
    protected String echeance;

    //sanitaire ou non
    @Column(nullable = false)
    protected String categorie;

    //location, réservation
    @Column(name = "disponibilite", nullable = false, length = 50)
    protected String disponibilite;

    @Column(nullable = false)
    protected int nbrChambre;

    @Column(nullable = false)
    protected int nbrCuisine;

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
