package com.memoire.wohaya;

import com.memoire.wohaya.domaine.Abonnement;
import com.memoire.wohaya.domaine.Proprietaire;
import com.memoire.wohaya.domaine.Utilisateur;
import com.memoire.wohaya.repository.AbonnementRepository;
import com.memoire.wohaya.repository.ProprietaireRepository;
import com.memoire.wohaya.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private final AbonnementRepository abonnementRepository;
    private final ProprietaireRepository proprietaireRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;


    public DbInit(AbonnementRepository abonnementRepository, UtilisateurRepository utilisateurRepository, ProprietaireRepository proprietaireRepository, PasswordEncoder passwordEncoder) {
        this.abonnementRepository = abonnementRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.proprietaireRepository = proprietaireRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Abonnement abonnement01 = new Abonnement(
            8,
            12000,
            10,
            10,
            10
        );
        Abonnement abonnement02 = new Abonnement(
            8,
            8000,
            5,
            5,
            5
        );
        Abonnement abonnement03 = new Abonnement(
            4,
            12000,
            20,
            20,
            20
        );
        Abonnement abonnement04 = new Abonnement(
            1,
            1000,
            2,
            2,
            2
        );
        Abonnement abonnement05 = new Abonnement(
            18,
            20000,
            20,
            20,
            20
        );
        Abonnement abonnement06 = new Abonnement(
            18,
            15000,
            15,
            15,
            15
        );
        Abonnement abonnement07 = new Abonnement(
            6,
            5000,
            3,
            3,
            3
        );
        Abonnement abonnement08 = new Abonnement(
            6,
            5000,
            5,
            5,
            0
        );
        Abonnement abonnement09 = new Abonnement(
            12,
            12000,
            10,
            5,
            0
        );
        Abonnement abonnement10 = new Abonnement(
            12,
            10000,
            5,
            5,
            10
        );
        List<Abonnement> abonnements = Arrays.asList(abonnement01,abonnement02,abonnement03,abonnement04,abonnement05,abonnement06,abonnement07,abonnement08,abonnement09,abonnement10);
        abonnementRepository.saveAll(abonnements);

        Utilisateur user1 = new Utilisateur(
            "John", "Doe",
            "61677113",
            passwordEncoder.encode("user"),
            "jdo@gmail.com",
            "masculin",
            "CLIENT",
            ""
        );
        Utilisateur user2 = new Utilisateur(
            "AMOU",
            "Alfred",
            "91001439",
            passwordEncoder.encode("AZuj877"),
            "jdo@hotmail.com",
            "masculin",
            "CLIENT",
            ""
        );
        List<Utilisateur> utilisateurs = Arrays.asList(user1, user2);
        utilisateurRepository.saveAll(utilisateurs);

        Proprietaire proprietaire1 = new Proprietaire(
            "SOVI",
            "Bertrand",
            "6784589",
            passwordEncoder.encode("Jdoww75"),
            "bert@gmail.com",
            "masculin",
            "PROPRIETAIRE",
            "ACCESS_ALL",
            "actif",
            LocalDate.now(),
            LocalDate.now().plusMonths(abonnement02.getDuree()),
            abonnement02
        );
        Proprietaire proprietaire2 = new Proprietaire(
            "TANTO",
            "Josiane",
            "96578456",
            passwordEncoder.encode("AZuj877!!"),
            "jos@hotmail.com", "feminin",
            "PROPRIETAIRE",
            "ACCESS_ALL",
            "actif",
            LocalDate.now(),
            LocalDate.now().plusMonths(abonnement03.getDuree()),
            abonnement03
        );
        List<Proprietaire> proprietaires = Arrays.asList(proprietaire1, proprietaire2);
        proprietaireRepository.saveAll(proprietaires);

    }

}
