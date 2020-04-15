package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    public List<Publication> getAllByStatusIgnoreCase(String status);

}
