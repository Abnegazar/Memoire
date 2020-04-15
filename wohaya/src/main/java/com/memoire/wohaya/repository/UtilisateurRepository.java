package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Nullable
    Utilisateur findByTelephone(String telephone);

    @Nullable
    Utilisateur findByTelephoneAndPwd(String phone, String pwd);

    boolean existsByTelephoneAndPwd(String phone, String pwd);

    void deleteByTelephoneAndPwd(String phone, String pwd);

    /*@Query("select u from Utilisateur u where u.role = ?1")
    List<Utilisateur> findAllByRole(String role);*/

}
