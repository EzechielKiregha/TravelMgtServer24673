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
    
    @Override
    public boolean registerUser(User user) {
        if (userDao.isEmailDuplicated(user.getEmail()) || userDao.isUsernameDuplicated(user.getUsername())) {
            return false;
        }
        user.setVerificationCode(generateVerificationCode());
        user.setStatus("Pending");
        // Send verification email using the code (use your email service here)
        return userDao.registerUser(user);
    }

    @Override
    public boolean verifyUser(Long userId, String code) {
        return userDao.verifyUser(userId, code);
    }

    @Override
    public boolean loginUser(String email, String password) {
        return userDao.loginUser(email, password);
    }

    @Override
    public String generateVerificationCode() {
        return userDao.generateVerificationCode();
    }

    @Override
    public boolean isEmailDuplicated(String email) {
        return userDao.isEmailDuplicated(email);
    }

    @Override
    public boolean isUsernameDuplicated(String username) {
        return userDao.isUsernameDuplicated(username);
    }
}
