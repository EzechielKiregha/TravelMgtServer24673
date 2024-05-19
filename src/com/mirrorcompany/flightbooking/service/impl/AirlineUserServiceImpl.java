/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.AirlineUserDao;
import com.mirrorcompany.flightbooking.model.AirlineUsers;
import com.mirrorcompany.flightbooking.service.AirlineUserService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class AirlineUserServiceImpl extends UnicastRemoteObject implements AirlineUserService{
    public AirlineUserServiceImpl() throws RemoteException{
    }
    AirlineUserDao dao = new AirlineUserDao();

    @Override
    public AirlineUsers recordUsers(AirlineUsers user) throws RemoteException {
        return dao.add_User(user);
    }

    @Override
    public AirlineUsers deleteUsers(AirlineUsers user) throws RemoteException {
        return dao.delete_User(user);
    }

    @Override
    public AirlineUsers updateUsers(AirlineUsers user) throws RemoteException {
        return dao.update_User(user);
    }

    @Override
    public AirlineUsers searchUsers(AirlineUsers user) throws RemoteException {
        return dao.search_user(user);
    }

    @Override
    public List<AirlineUsers> theuser() throws RemoteException {
        return dao.user();
    }

    @Override
    public AirlineUsers checkCredentials(AirlineUsers user) throws RemoteException {
        return dao.checkCredentials(user);
    }

    @Override
    public AirlineUsers checkEmail(AirlineUsers user) throws RemoteException {
        return dao.mailChecker(user);
    }
    
}
