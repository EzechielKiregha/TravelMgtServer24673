
package com.mirrorcompany.service.impl;

import com.mirrorcompany.dao.RecommendationDao;
import com.mirrorcompany.model.Recommendation;
import com.mirrorcompany.service.RecommendationService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RecommendationServiceImpl extends UnicastRemoteObject implements RecommendationService {
    private static final long serialVersionUID = 1L;
    private RecommendationDao recommendationDao;

    public RecommendationServiceImpl() throws RemoteException {
        super();
        recommendationDao = new RecommendationDao();
    }

    @Override
    public boolean addRecommendation(Recommendation recommendation) throws RemoteException {
        return recommendationDao.addRecommendation(recommendation);
    }

    @Override
    public Recommendation findRecommendationById(Long recommendationId) throws RemoteException {
        return recommendationDao.findRecommendationById(recommendationId);
    }

    @Override
    public boolean updateRecommendation(Recommendation recommendation) throws RemoteException {
        return recommendationDao.updateRecommendation(recommendation);
    }

    @Override
    public boolean deleteRecommendation(Recommendation recommendation) throws RemoteException {
        return recommendationDao.deleteRecommendation(recommendation);
    }

    @Override
    public List<Recommendation> findAllRecommendationsByUserId(Long userId) throws RemoteException {
        return recommendationDao.findAllRecommendationsByUserId(userId);
    }
}
