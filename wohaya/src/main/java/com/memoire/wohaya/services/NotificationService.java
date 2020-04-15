package com.memoire.wohaya.services;

import com.memoire.wohaya.domaine.Notification;
import com.memoire.wohaya.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification save(Notification notification){
        return notificationRepository.save(notification);
    }

    public List<Notification> getAll(){
        return notificationRepository.findAll();
    }

    public Notification findOne(Long id){
        return notificationRepository.getOne(id);
    }

    public List<Notification> getsByObject(String objet){
        return notificationRepository.getAllByObjetIgnoreCase(objet);
    }

    public Notification update(Notification notification){
        return notificationRepository.saveAndFlush(notification);
    }

    public Boolean existOne(Long id){
        return notificationRepository.existsById(id);
    }

    public Long count(){
        return notificationRepository.count();
    }

    public void deleteOne(Long id){
        notificationRepository.deleteById(id);
    }

    public void deleteAll(){
        notificationRepository.deleteAll();
    }

}
