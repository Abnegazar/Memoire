package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "client")
@DiscriminatorColumn(name = "role")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    private String telephone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, length = 8)
    private String sexe;

    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    private List<Annonce> annonces = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    private List<Reservation> reservations= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "destinataire")
    private List<Notification> notifications = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    private List<Appreciation> appreciations = new ArrayList<>();

}
