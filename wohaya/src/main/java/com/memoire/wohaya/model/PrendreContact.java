package com.memoire.wohaya.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PrendreContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;

    @OneToOne(optional = false)
    @JoinColumn(name = "proprietaire")
    private Utilisateur utilisateur;

    @OneToOne(optional = false)
    @JoinColumn(name = "client")
    private Utilisateur client;

    @Column(nullable = false, name = "date_contact")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateContact;

}
