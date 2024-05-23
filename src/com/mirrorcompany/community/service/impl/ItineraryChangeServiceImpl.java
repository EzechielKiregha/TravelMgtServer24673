package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.ItineraryChangeDao;
import com.mirrorcompany.community.model.ItineraryChange;
import com.mirrorcompany.community.service.ItineraryChangeService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ItineraryChangeServiceImpl extends UnicastRemoteObject implements ItineraryChangeService {

    private ItineraryChangeDao itineraryChangeDao;

    public ItineraryChangeServiceImpl() throws RemoteException {
        itineraryChangeDao = new ItineraryChangeDao();
    }

    @Override
    public void createItineraryChange(ItineraryChange itineraryChange) throws RemoteException {
        itineraryChangeDao.createItineraryChange(itineraryChange);
    }

    @Override
    public ItineraryChange getItineraryChangeById(Long changeId) throws RemoteException {
        return itineraryChangeDao.getItineraryChangeById(changeId);
    }

    @Override
    public List<ItineraryChange> getAllItineraryChanges() throws RemoteException {
        return itineraryChangeDao.getAllItineraryChanges();
    }

    @Override
    public void updateItineraryChange(ItineraryChange itineraryChange) throws RemoteException {
        itineraryChangeDao.updateItineraryChange(itineraryChange);
    }

    @Override
    public void deleteItineraryChange(Long changeId) throws RemoteException {
        itineraryChangeDao.deleteItineraryChange(changeId);
    }

    @Override
    public List<ItineraryChange> getItineraryChangesByUser(Long userId) throws RemoteException {
        return itineraryChangeDao.getItineraryChangesByUser(userId);
    }

    @Override
    public List<ItineraryChange> getItineraryChangesByItinerary(Long itineraryId) throws RemoteException {
        return itineraryChangeDao.getItineraryChangesByItinerary(itineraryId);
    }
}

