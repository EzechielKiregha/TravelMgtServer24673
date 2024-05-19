/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.PlaneDao;
import com.mirrorcompany.flightbooking.model.AirPlane;
import com.mirrorcompany.flightbooking.service.PlaneService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class PlaneServiceImpl extends UnicastRemoteObject implements PlaneService{
    public PlaneServiceImpl() throws RemoteException{
    }
    PlaneDao dao = new PlaneDao();

    @Override
    public AirPlane recordPlane(AirPlane plane) throws RemoteException {
        return dao.add_Plane(plane);
    }

    @Override
    public AirPlane deletePlane(AirPlane plane) throws RemoteException {
        return dao.delete_Plane(plane);
    }

    @Override
    public AirPlane updatePlane(AirPlane plane) throws RemoteException {
        return dao.update_Plane(plane);
    }

    @Override
    public AirPlane searchPlane(AirPlane plane) throws RemoteException {
        return dao.search_plane(plane);
    }

    @Override
    public List<AirPlane> theplane() throws RemoteException {
        return dao.plane();
    }
    
}
