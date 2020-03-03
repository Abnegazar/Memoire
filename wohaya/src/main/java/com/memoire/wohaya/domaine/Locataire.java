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
@DiscriminatorValue(value = "utilisateur")
@DiscriminatorColumn(name = "role")
@Inheritance(strategy = InheritanceType.JOINED)
public class Locataire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true)
    private String telephone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, length = 8)
    private String sexe;

    private String photo;

    @OneToMany(mappedBy = "auteur")
    private List<Annonce> annonces = new ArrayList<>();

    @OneToMany(mappedBy = "auteur")
    private List<Reservation> reservations= new ArrayList<>();

    @OneToMany(mappedBy = "destinataire")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "auteur")
    private List<Appreciation> appreciations = new ArrayList<>();

}
