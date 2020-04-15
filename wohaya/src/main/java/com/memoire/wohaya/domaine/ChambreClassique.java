package com.memoire.wohaya.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorValue("chambre_classique")
public class ChambreClassique extends Logement implements Serializable {

    @Column(nullable = false)
    private int nbrPieces;

    @Column(nullable = false)
    private boolean cuisineInterne;

    @Column(nullable = false)
    private boolean doucheInterne;

}
