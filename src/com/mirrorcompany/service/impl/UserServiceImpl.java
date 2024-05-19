package com.mirrorcompany.service.impl;

import com.mirrorcompany.dao.UserDao;
import com.mirrorcompany.model.User;
import com.mirrorcompany.service.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public UserServiceImpl() throws RemoteException {
        super();
        userDao = new UserDao();
    }

    @Override
    public boolean addUser(User user) throws RemoteException {
        return userDao.addUser(user);
    }

    @Override
    public User findUserByEmail(User user) throws RemoteException {
        return userDao.findUserByEmail(user);
    }

    @Override
    public boolean updateUser(User user) throws RemoteException {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) throws RemoteException {
        return userDao.deleteUser(user);
    }

    @Override
    public List<User> findAllUsers() throws RemoteException {
        return userDao.findAllUsers();
    }
    @Override
    public boolean verifyUserCredentials(User user) throws RemoteException {
        User storedUser = userDao.findUserByEmail(user);
        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            System.out.println("True");
            return true; // Credentials are valid
        } else {
            System.out.println("False");
            return false; // Credentials are invalid
        }
        
    }
}
