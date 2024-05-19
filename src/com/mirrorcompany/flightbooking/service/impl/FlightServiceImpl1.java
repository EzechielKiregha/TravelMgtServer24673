/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.FlightDao11;
import com.mirrorcompany.flightbooking.model.Flight1;
import com.mirrorcompany.flightbooking.service.FlightService11;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class FlightServiceImpl1 extends UnicastRemoteObject implements FlightService11{
    public FlightServiceImpl1() throws RemoteException{
    }
    FlightDao11 dao = new FlightDao11();

    @Override
    public Flight1 recordFlight(Flight1 flight) {
        return dao.saveFlight1(flight);
    }
    @Override
    public Flight1 deleteFlight(Flight1 flight) throws RemoteException {
        return dao.deletePassenger(flight);    }

    @Override
    public Flight1 updateFlight(Flight1 flight) throws RemoteException {
        return dao.updatePassenger(flight);
    }

    @Override
    public Flight1 searchFlight(Flight1 flight) throws RemoteException {
        return dao.search(flight);
    }

    @Override
    public List<Flight1> allFlights1() throws RemoteException {
        return dao.getAllflight();
    }
}
