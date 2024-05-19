/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.PassengerDao;
import com.mirrorcompany.flightbooking.model.AirlinePassenger;
import com.mirrorcompany.flightbooking.service.PassengerService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class PassengerServiceImpl extends UnicastRemoteObject implements PassengerService{
    public PassengerServiceImpl() throws RemoteException{
    }
    PassengerDao dao = new PassengerDao();

    @Override
    public AirlinePassenger recordPassenger(AirlinePassenger passenger) throws RemoteException {
        return dao.add_Passenger(passenger);
    }

    @Override
    public AirlinePassenger deletePassenger(AirlinePassenger passenger) throws RemoteException {
        return dao.delete_Passenger(passenger);
    }

    @Override
    public AirlinePassenger updatePassenger(AirlinePassenger passenger) throws RemoteException {
        return dao.update_Passenger(passenger);
    }

    @Override
    public AirlinePassenger searchPassenger(AirlinePassenger passenger) throws RemoteException {
        return dao.search_passenger(passenger);
    }

    @Override
    public List<AirlinePassenger> thepassenger() throws RemoteException {
        return dao.passenger();
    }
    
}
