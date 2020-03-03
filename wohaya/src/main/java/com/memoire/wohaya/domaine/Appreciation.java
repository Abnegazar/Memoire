package com.memoire.wohaya.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appreciation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppreciation;

    @Column(name = "valeur", nullable = false)
    private int valeur;

    private String avis;

    @OneToOne
    @JoinColumn(name = "auteur")
    private Locataire auteur;

    @OneToOne
    @JoinColumn(name = "publication")
    private Publication publication;

}
