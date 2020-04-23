package com.memoire.wohaya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idUtilisateur;

    @Column(nullable = false)
    protected String nom;


    @Column(nullable = false)
    protected String prenom;

    //User Telephone is his username
    @ApiModelProperty(notes = "Numero de téléphone de l'utilisateur")
    @Column(unique = true, nullable = false)
    protected String username;

    @ApiModelProperty(notes = "Mot de passe de l'utilisateur")
    @Column(name = "pwd", nullable = false)
    protected String pwd;

    @Column(unique = true)
    protected String email;

    @ApiModelProperty(notes = "masculin ou féminin : en toutes lettres")
    @Column(nullable = false, length = 8)
    protected String sexe;

    protected String photo;

    @ApiModelProperty(notes = "plusieurs roles possibles séparés par des virgules")
    protected String roles;

    @ApiModelProperty(notes = "plusieurs permissions possibles séparées par des virgules")
    protected String permissions;

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    protected List<Annonce> annonces = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    protected List<Reservation> reservations= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "destinataire")
    protected List<Notification> notifications = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "auteur")
    protected List<Appreciation> appreciations = new ArrayList<>();

    public Utilisateur (String nom, String prenom, String username, String pwd, String mail, String sexe, String roles, String permissions){
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.pwd = pwd;
        this.email = mail;
        this.sexe = sexe;
        this.roles = roles;
        this.permissions = permissions;
    }

    public List<String> getRolesList(){
        if(this.roles.length() > 0 ){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionsList(){
        if(this.permissions.length() > 0 ){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

}
