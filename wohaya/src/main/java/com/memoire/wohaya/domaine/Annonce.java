package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;

    @Column(nullable = false)
    private String objet;

    @Column(nullable = false)
    @JsonFormat(pattern = "jj/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateAnnonce;

    private float prixMin;

    private float prixMax;

    @Column(nullable = false)
    private int nbrChambre;

    @Column(nullable = false)
    private String typeLocation;

    @Embedded
    private Localisation localisation;

    @OneToOne
    @JoinColumn(name = "auteur")
    private Locataire auteur;

}
