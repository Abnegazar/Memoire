package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Nullable
    Utilisateur findByTelephoneAndPassword(String phone, String pwd);

    void deleteByTelephoneAndPassword(String phone, String pwd);

    /*@Query("select u from Utilisateur u where u.role = ?1")
    List<Utilisateur> findAllByRole(String role);*/

}
