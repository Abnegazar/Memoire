package com.memoire.wohaya.db;

import com.memoire.wohaya.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> getAllByObjetIgnoreCase(String objet);
}
