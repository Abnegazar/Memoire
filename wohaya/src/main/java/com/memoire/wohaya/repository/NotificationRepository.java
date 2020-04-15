package com.memoire.wohaya.repository;

import com.memoire.wohaya.domaine.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> getAllByObjetIgnoreCase(String objet);
}
