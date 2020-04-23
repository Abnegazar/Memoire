package com.memoire.wohaya.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChambreClassique extends Logement implements Serializable {

    @ApiModelProperty(notes = "Nombre total de pièces. Salon et chambres confondus.")
    @Column(nullable = false)
    private int nbrPieces;

    @ApiModelProperty(notes = "true ou false")
    @Column(nullable = false)
    private boolean cuisineInterne;

    @ApiModelProperty(notes = "true ou false")
    @Column(nullable = false)
    private boolean doucheInterne;

}
