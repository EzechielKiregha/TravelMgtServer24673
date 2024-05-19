
package com.mirrorcompany.community.service.impl;
import com.mirrorcompany.community.dao.NotificationDao;
import com.mirrorcompany.community.model.Notification;
import com.mirrorcompany.community.service.NotificationService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NotificationServiceImpl extends UnicastRemoteObject implements NotificationService {

    private NotificationDao notificationDao;

    protected NotificationServiceImpl() throws RemoteException {
        notificationDao = new NotificationDao();
    }

    @Override
    public void createNotification(Notification notification) throws RemoteException {
        notificationDao.createNotification(notification);
    }

    @Override
    public Notification getNotificationById(Long notificationId) throws RemoteException {
        return notificationDao.getNotificationById(notificationId);
    }

    @Override
    public List<Notification> getAllNotifications() throws RemoteException {
        return notificationDao.getAllNotifications();
    }

    @Override
    public void updateNotification(Notification notification) throws RemoteException {
        notificationDao.updateNotification(notification);
    }

    @Override
    public void deleteNotification(Long notificationId) throws RemoteException {
        notificationDao.deleteNotification(notificationId);
    }

    @Override
    public List<Notification> getNotificationsByUser(Long userId) throws RemoteException {
        return notificationDao.getNotificationsByUser(userId);
    }

    @Override
    public void markAsRead(Long notificationId) throws RemoteException {
        notificationDao.markAsRead(notificationId);
    }
}
