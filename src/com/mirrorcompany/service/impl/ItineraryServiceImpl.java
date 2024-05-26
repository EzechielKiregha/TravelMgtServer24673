package com.mirrorcompany.service.impl;

import com.mirrorcompany.dao.ItineraryDao;
import com.mirrorcompany.model.Itinerary;
import com.mirrorcompany.service.ItineraryService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ItineraryServiceImpl extends UnicastRemoteObject implements ItineraryService {
    private static final long serialVersionUID = 1L;
    private ItineraryDao itineraryDao = new ItineraryDao();

    public ItineraryServiceImpl() throws RemoteException {
        
        
    }

    @Override
    public boolean addItinerary(Itinerary itinerary) throws RemoteException {
        return itineraryDao.addItinerary(itinerary);
    }

    @Override
    public Itinerary findItineraryById(Long itineraryId) throws RemoteException {
        return itineraryDao.findItineraryById(itineraryId);
    }

    @Override
    public boolean updateItinerary(Itinerary itinerary) throws RemoteException {
        return itineraryDao.updateItinerary(itinerary);
    }

    @Override
    public boolean deleteItinerary(Itinerary itinerary) throws RemoteException {
        return itineraryDao.deleteItinerary(itinerary);
    }

    @Override
    public List<Itinerary> findAllItinerariesByUserId(Long userId) throws RemoteException {
        return itineraryDao.findAllItinerariesByUserId(userId);
    }
}
