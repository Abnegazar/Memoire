package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageLogement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;

    @Column(nullable = false, unique = true)
    private String cheminImage;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "logement")
    private Logement logement;

}
