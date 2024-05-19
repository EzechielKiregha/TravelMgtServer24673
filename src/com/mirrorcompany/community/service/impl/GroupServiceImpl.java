/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.GroupDao;
import com.mirrorcompany.community.model.Group;
import com.mirrorcompany.community.service.GroupService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class GroupServiceImpl extends UnicastRemoteObject implements GroupService {
    private static final long serialVersionUID = 1L;
    private GroupDao groupDao;

    public GroupServiceImpl() throws RemoteException {
        super();
        groupDao = new GroupDao();
    }

    @Override
    public boolean createGroup(Group group) throws RemoteException {
        return groupDao.createGroup(group);
    }

    @Override
    public boolean joinGroup(Long userId, Long groupId) throws RemoteException {
        return groupDao.joinGroup(userId, groupId);
    }

    @Override
    public boolean leaveGroup(Long userId, Long groupId) throws RemoteException {
        return groupDao.leaveGroup(userId, groupId);
    }

    @Override
    public List<Group> getGroupsByUserId(Long userId) throws RemoteException {
        return groupDao.getGroupsByUserId(userId);
    }
}
