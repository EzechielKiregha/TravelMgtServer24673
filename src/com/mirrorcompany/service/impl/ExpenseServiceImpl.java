package com.mirrorcompany.service.impl;

import com.mirrorcompany.dao.ExpenseDao;
import com.mirrorcompany.model.Expense;
import com.mirrorcompany.service.ExpenseService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ExpenseServiceImpl extends UnicastRemoteObject implements ExpenseService {
    private static final long serialVersionUID = 1L;
    private ExpenseDao expenseDao = new ExpenseDao();

    public ExpenseServiceImpl() throws RemoteException {
        
    }

    @Override
    public boolean addExpense(Expense expense) throws RemoteException {
        return expenseDao.addExpense(expense);
    }

    @Override
    public Expense findExpenseById(Long expenseId) throws RemoteException {
        return expenseDao.findExpenseById(expenseId);
    }

    @Override
    public boolean updateExpense(Expense expense) throws RemoteException {
        return expenseDao.updateExpense(expense);
    }

    @Override
    public boolean deleteExpense(Expense expense) throws RemoteException {
        return expenseDao.deleteExpense(expense);
    }

    @Override
    public List<Expense> findAllExpensesByUserId(Long userId) throws RemoteException {
        return expenseDao.findAllExpensesByUserId(userId);
    }
}
