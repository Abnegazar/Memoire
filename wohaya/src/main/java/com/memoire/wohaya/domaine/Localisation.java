package com.memoire.wohaya.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localisation implements Serializable {

    @OneToOne(optional = false)
    @JoinColumn(name = "ville")
    private Ville ville;

    @OneToOne
    @JoinColumn(name = "quartier")
    private Quartier quartier;

    @OneToOne
    @JoinColumn(name = "zone")
    private Zone zone;

}
