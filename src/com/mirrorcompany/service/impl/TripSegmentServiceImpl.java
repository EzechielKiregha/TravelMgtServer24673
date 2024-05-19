package com.mirrorcompany.service.impl;

import com.mirrorcompany.dao.TripSegmentDao;
import com.mirrorcompany.model.TripSegment;
import com.mirrorcompany.service.TripSegmentService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TripSegmentServiceImpl extends UnicastRemoteObject implements TripSegmentService {
    private static final long serialVersionUID = 1L;
    private TripSegmentDao tripSegmentDao;

    public TripSegmentServiceImpl() throws RemoteException {
        super();
        tripSegmentDao = new TripSegmentDao();
    }

    @Override
    public boolean addTripSegment(TripSegment tripSegment) throws RemoteException {
        return tripSegmentDao.addTripSegment(tripSegment);
    }

    @Override
    public TripSegment findTripSegmentById(Long segmentId) throws RemoteException {
        return tripSegmentDao.findTripSegmentById(segmentId);
    }

    @Override
    public boolean updateTripSegment(TripSegment tripSegment) throws RemoteException {
        return tripSegmentDao.updateTripSegment(tripSegment);
    }

    @Override
    public boolean deleteTripSegment(TripSegment tripSegment) throws RemoteException {
        return tripSegmentDao.deleteTripSegment(tripSegment);
    }

    @Override
    public List<TripSegment> findAllTripSegmentsByItineraryId(Long itineraryId) throws RemoteException {
        return tripSegmentDao.findAllTripSegmentsByItineraryId(itineraryId);
    }
}
