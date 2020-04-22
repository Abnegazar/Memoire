package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Publication;
import com.memoire.wohaya.services.PublicationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequestMapping("/wohaya-api/publication")
@RestController
@Api(value="Gestion des Publications de logements")
public class PublicationRessource {

    private final PublicationService publicationService;

    public PublicationRessource(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Publication> save(@RequestBody Publication publication){
        if(publication.getDatePublication() == null){
            publication.setDatePublication(LocalDate.now(ZoneId.of("Africa/Porto-Novo")));
        }
        return new ResponseEntity<>(publicationService.save(publication), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Publication>> getAll(){
        return new ResponseEntity<>(publicationService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(publicationService.findOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Publication>> getAllByStatus(@PathVariable("status") String status){
        return new ResponseEntity<>(publicationService.getAllByStatus(status), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publication> update(@PathVariable("id") Long id, @RequestBody Publication publication){
        if (existId(id)){
            return new ResponseEntity<>(publicationService.update(publication), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return publicationService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return publicationService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        publicationService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        publicationService.deleteAll();
    }

}
