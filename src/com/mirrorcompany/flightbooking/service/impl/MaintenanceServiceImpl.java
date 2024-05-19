/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.flightbooking.service.impl;

import com.mirrorcompany.flightbooking.dao.MaintenanceDao;
import com.mirrorcompany.flightbooking.model.AirlineMaintenance;
import com.mirrorcompany.flightbooking.service.MaintenanceService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author drg
 */
public class MaintenanceServiceImpl extends UnicastRemoteObject implements MaintenanceService{
    public MaintenanceServiceImpl() throws RemoteException{
    }
    MaintenanceDao dao = new MaintenanceDao();

    @Override
    public AirlineMaintenance recordMaintenance(AirlineMaintenance maintenance) throws RemoteException {
        return dao.add_Maintenance(maintenance);
    }

    @Override
    public AirlineMaintenance deleteMaintenance(AirlineMaintenance maintenance) throws RemoteException {
        return dao.delete_Maintenance(maintenance);
    }

    @Override
    public AirlineMaintenance updateMaintenance(AirlineMaintenance maintenance) throws RemoteException {
        return dao.update_Maintenance(maintenance);
    }

    @Override
    public AirlineMaintenance searchMaintenance(AirlineMaintenance maintenance) throws RemoteException {
        return dao.search_maintenance(maintenance);
    }

    @Override
    public List<AirlineMaintenance> themaintenance() throws RemoteException {
        return dao.maintenance();
    }
    
}
