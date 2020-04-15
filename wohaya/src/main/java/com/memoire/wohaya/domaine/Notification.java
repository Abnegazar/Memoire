package com.memoire.wohaya.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotifications;

    @Column(nullable = false)
    private String objet;

    @Column(nullable = false)
    private String contenu;

    @Column(nullable = false, name = "date_notification")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Africa/Porto-Novo")
    private LocalDate dateNotification;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "destinataire")
    private Utilisateur destinataire;

}
