package com.memoire.wohaya.db;

import com.memoire.wohaya.model.PrendreContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrendreContactRepository extends JpaRepository<PrendreContact, Long> {
}
