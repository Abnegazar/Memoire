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
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublication;

    @ApiModelProperty(notes = "active ou inactive selon la validité de l'abonnement du propriétaire.")
    @Column(nullable = false)
    private String status;

    @Column(nullable = false, name = "date_publication")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate datePublication;

    @OneToOne
    @JoinColumn(name = "logement", nullable = false)
    private Logement logement;

}
