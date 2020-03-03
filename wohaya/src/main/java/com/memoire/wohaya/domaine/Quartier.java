package com.memoire.wohaya.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quartier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuartier;

    @Column(nullable = false)
    private String nomQuartier;

    @ManyToOne
    @JoinColumn(name = "ville", nullable = false)
    private Ville ville;

    @OneToMany(mappedBy = "quartier")
    private List<Zone> zones = new ArrayList<>();

}
