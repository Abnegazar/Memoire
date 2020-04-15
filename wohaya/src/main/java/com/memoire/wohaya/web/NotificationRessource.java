package com.memoire.wohaya.web;

import com.memoire.wohaya.domaine.Notification;
import com.memoire.wohaya.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequestMapping("/wohaya-api/notification")
@RestController
public class NotificationRessource {

    private final NotificationService notificationService;

    public NotificationRessource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Notification> save(@RequestBody Notification notification){
        if(notification.getDateNotification() == null){
            notification.setDateNotification(LocalDate.now(ZoneId.of("Africa/Porto-Novo")));
        }
        return new ResponseEntity<>(notificationService.save(notification), HttpStatus.CREATED);
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<Notification>> getAll(){
        return new ResponseEntity<>(notificationService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getOne(@PathVariable("id") long id){
        return new ResponseEntity<>(notificationService.findOne(id), HttpStatus.FOUND);
    }

    @GetMapping("/{objet}")
    public ResponseEntity<List<Notification>> getsObjets(@PathVariable("objet") String objet){
        return new ResponseEntity<>(notificationService.getsByObject(objet), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> update(@PathVariable("id") Long id, @RequestBody Notification notification){
        if (existId(id)){
            return new ResponseEntity<>(notificationService.update(notification), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/exist/{id}")
    public Boolean existId(@PathVariable("id") Long id){
        return notificationService.existOne(id);
    }

    @GetMapping("/count")
    public Long countAll(){
        return notificationService.count();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id){
        notificationService.deleteOne(id);
    }

    @DeleteMapping("/delete_all")
    public void deleteAll(){
        notificationService.deleteAll();
    }

}
