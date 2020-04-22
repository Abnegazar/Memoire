package com.memoire.wohaya.domaine;

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
public class Residence extends Logement implements Serializable {

    @ApiModelProperty(notes = "true(présente) ou false(absente)")
    @Column(nullable = false)
    private boolean piscine;

    @ApiModelProperty(notes = "true(présent) ou false(absent)")
    @Column(nullable = false)
    private boolean jardin;

}
