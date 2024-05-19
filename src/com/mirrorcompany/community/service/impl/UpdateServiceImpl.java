package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.UpdateDao;
import com.mirrorcompany.community.model.Update;
import com.mirrorcompany.community.service.UpdateService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UpdateServiceImpl extends UnicastRemoteObject implements UpdateService {

    private UpdateDao updateDao;

    protected UpdateServiceImpl() throws RemoteException {
        updateDao = new UpdateDao();
    }

    @Override
    public void createUpdate(Update update) throws RemoteException {
        updateDao.createUpdate(update);
    }

    @Override
    public Update getUpdateById(Long updateId) throws RemoteException {
        return updateDao.getUpdateById(updateId);
    }

    @Override
    public List<Update> getAllUpdates() throws RemoteException {
        return updateDao.getAllUpdates();
    }

    @Override
    public void updateUpdate(Update update) throws RemoteException {
        updateDao.updateUpdate(update);
    }

    @Override
    public void deleteUpdate(Long updateId) throws RemoteException {
        updateDao.deleteUpdate(updateId);
    }

    @Override
    public List<Update> getUpdatesByUser(Long userId) throws RemoteException {
        return updateDao.getUpdatesByUser(userId);
    }

    @Override
    public void likeUpdate(Long userId, Long updateId) throws RemoteException {
        updateDao.likeUpdate(userId, updateId);
    }

    @Override
    public void unlikeUpdate(Long userId, Long updateId) throws RemoteException {
        updateDao.unlikeUpdate(userId, updateId);
    }
}

