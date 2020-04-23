package com.memoire.wohaya.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Proprietaire extends Utilisateur {

    //etat de l'abonnement du propriétaire entre "inactif", "actif"
    @ApiModelProperty(notes = "actif ou inactif")
    @Column(name = "etat_abonnement")
    private String etatAbonnement;

    @ApiModelProperty(notes = "Date courante par défaut si rien n'est mis")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(name = "debut_abonnement")
    private LocalDate debutAbonnement;

    @ApiModelProperty(notes = "Automatiquement calculé à l'insertion en base")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(name = "fin_abonnement")
    private LocalDate finAbonnement;

    @ManyToOne
    @JoinColumn(name = "abonnement")
    private Abonnement abonnement;

    public Proprietaire(String nom, String prenom, String telephone, String pwd, String email, String sexe, String roles, String permissions
            , String etatAbonnement, LocalDate debutAbonnement, LocalDate finAbonnement, Abonnement abonnement){

        super(nom, prenom, telephone, pwd, email, sexe, roles, permissions);
        this.etatAbonnement = etatAbonnement;
        this.debutAbonnement = debutAbonnement;
        this.finAbonnement = finAbonnement;
        this.abonnement = abonnement;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire")
    private List<Logement> logements = new ArrayList<>();
}
