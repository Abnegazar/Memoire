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
public class Appartement extends Logement implements Serializable {

    @ApiModelProperty(notes = "true ou false")
    @Column(nullable = false)
    private boolean meubler;

}
