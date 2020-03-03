package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Locataire proprietaire;

    @OneToOne(optional = false)
    @JoinColumn(name = "client")
    private Locataire client;

    @Column(nullable = false)
    @JsonFormat(pattern = "jj/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateContact;

}
