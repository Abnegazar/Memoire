package com.memoire.wohaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZone;

    @Column(nullable = false)
    private String nomZone;

    @ManyToOne
    @JoinColumn(name = "quartier", nullable = false)
    private Quartier quartier;

    @Column(nullable = false)
    @NotNull(message = "Le type de la zone est requis.")
    private String typeZone;

}
