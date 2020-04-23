package com.memoire.wohaya.model;

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
public class Ville implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;

    @Column(unique = true, nullable = false)
    private String nomVille;

    @OneToMany(mappedBy = "ville")
    private List<Quartier> quartiers = new ArrayList<>();

}
