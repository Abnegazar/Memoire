package com.memoire.wohaya.db;

import com.memoire.wohaya.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByUsername(String username);

    @Nullable
    Utilisateur findByUsernameAndPwd(String phone, String pwd);

    boolean existsByUsernameAndPwd(String phone, String pwd);

    void deleteByUsernameAndPwd(String phone, String pwd);

    /*@Query("select u from Utilisateur u where u.role = ?1")
    List<Utilisateur> findAllByRole(String role);*/

}
