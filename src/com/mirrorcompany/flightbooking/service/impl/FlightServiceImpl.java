/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.FlightDao;
import com.mirrorcompany.flightbooking.model.Flight;
import com.mirrorcompany.flightbooking.service.FlightService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class FlightServiceImpl extends UnicastRemoteObject implements FlightService{
    public FlightServiceImpl() throws RemoteException{
    }
    FlightDao dao = new FlightDao();

    @Override
    public Flight recordFlight(Flight flight) throws RemoteException {
        return dao.add_Flight(flight);
    }

    @Override
    public Flight deleteFlight(Flight flight) throws RemoteException {
        return dao.delete_Flight(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) throws RemoteException {
        return dao.update_Flight(flight);
    }

    @Override
    public Flight searchFlight(Flight flight) throws RemoteException {
        return dao.search_flight(flight);
    }

    @Override
    public List<Flight> theflight() throws RemoteException {
        return dao.flight();
    }
    
}
