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
public class Appreciation implements Serializable {

    //Note donnée à la publication
    @ApiModelProperty(notes = "Note de la publication")
    @Column(name = "valeur", nullable = false)
    private int valeur;

    //Commentaire
    @ApiModelProperty(notes = "Commentaire")
    private String avis;

    @ApiModelProperty(notes = "Date du commentaire : la date courante si rien n'est mis.")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(nullable = false, name = "date_appr")
    private LocalDate dateAppr;

    @Id
    @ManyToOne
    @JoinColumn(name = "auteur")
    private Utilisateur auteur;

    @Id
    @OneToOne
    @JoinColumn(name = "publication")
    private Publication publication;

}
