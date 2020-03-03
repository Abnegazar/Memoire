/*
package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    @Query(value = "SELECT u FROM Annonce a WHERE a.prixMin <= ?1 and a.prixMax >= ?2")
    List<Annonce> anonceparPrix(float prixMin, float prixMax);

    @Query(value = "select u from Annonce a where a.localisation = ?1")
    List<Annonce> findAllByLocalisation(int localisation);



}
*/
