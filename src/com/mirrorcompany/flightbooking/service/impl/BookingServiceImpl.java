/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.BookingDao;
import com.mirrorcompany.flightbooking.model.AirlineBooking;
import com.mirrorcompany.flightbooking.service.BookingService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class BookingServiceImpl extends UnicastRemoteObject implements BookingService{
    public BookingServiceImpl() throws RemoteException{
    }
    BookingDao dao = new BookingDao();

    @Override
    public AirlineBooking recordBooking(AirlineBooking booking) throws RemoteException {
        return dao.add_Booking(booking);
    }

    @Override
    public AirlineBooking deleteBooking(AirlineBooking booking) throws RemoteException {
        return dao.delete_Booking(booking);
    }

    @Override
    public AirlineBooking updateBooking(AirlineBooking booking) throws RemoteException {
        return dao.update_Booking(booking);
    }

    @Override
    public AirlineBooking searchBooking(AirlineBooking booking) throws RemoteException {
        return dao.search_booking(booking);
    }

    @Override
    public List<AirlineBooking> thebooking() throws RemoteException {
        return dao.booking();
    }
    
}
