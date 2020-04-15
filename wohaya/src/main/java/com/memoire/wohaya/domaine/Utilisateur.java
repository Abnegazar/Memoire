package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
/*@DiscriminatorValue(value = "client")
@DiscriminatorColumn(name = "role")*/
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idUtilisateur;

    @Column(nullable = false)
    protected String nom;

    @Column(nullable = false)
    protected String prenom;

    @Column(unique = true, nullable = false)
    protected String telephone;

    @Column(name = "pwd", nullable = false)
    protected String pwd;

    @Column(unique = true)
    protected String email;

    @Column(nullable = false, length = 8)
    protected String sexe;

    protected String photo;

    protected String roles;

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

    public Utilisateur (String nom, String prenom, String telephone, String pwd, String mail, String sexe, String roles, String permissions){
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
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
