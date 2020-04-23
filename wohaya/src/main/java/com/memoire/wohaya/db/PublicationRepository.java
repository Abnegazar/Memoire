package com.memoire.wohaya.db;

import com.memoire.wohaya.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    public List<Publication> getAllByStatusIgnoreCase(String status);

}
