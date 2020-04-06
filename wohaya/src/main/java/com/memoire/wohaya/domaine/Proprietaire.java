package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "proprietaire")
public class Proprietaire extends Utilisateur {

    //etat de l'abonnement du propriétaire entre "inactif", "actif"
    @Column(name = "etat_abonnement")
    private String etatAbonnement;


    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(name = "debut_abonnement")
    private LocalDate debutAbonnement;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    @Column(name = "fin_abonnement")
    private LocalDate finAbonnement;

    @OneToOne
    @JoinColumn(name = "abonnement")
    private Abonnement abonnement;

    @JsonIgnore
    @OneToMany(mappedBy = "proprietaire")
    private List<Logement> logements = new ArrayList<>();
}
