package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Appreciation implements Serializable {

    //Note donnée à la publication
    @Column(name = "valeur", nullable = false)
    private int valeur;

    //Commentaire
    private String avis;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(nullable = false, name = "date_appr")
    private LocalDate dateAppr;

    @Id
    @OneToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

    @Id
    @OneToOne
    @JoinColumn(name = "publication")
    private Publication publication;

}
