/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.CommentDao;
import com.mirrorcompany.community.model.Comment;
import com.mirrorcompany.community.service.CommentService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CommentServiceImpl extends UnicastRemoteObject implements CommentService {

    private CommentDao commentDao;

    protected CommentServiceImpl() throws RemoteException {
        commentDao = new CommentDao();
    }

    @Override
    public void createComment(Comment comment) throws RemoteException {
        commentDao.createComment(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) throws RemoteException {
        return commentDao.getCommentById(commentId);
    }

    @Override
    public List<Comment> getAllComments() throws RemoteException {
        return commentDao.getAllComments();
    }

    @Override
    public void updateComment(Comment comment) throws RemoteException {
        commentDao.updateComment(comment);
    }

    @Override
    public void deleteComment(Long commentId) throws RemoteException {
        commentDao.deleteComment(commentId);
    }

    @Override
    public List<Comment> getCommentsByUser(Long userId) throws RemoteException {
        return commentDao.getCommentsByUser(userId);
    }

    @Override
    public List<Comment> getCommentsByUpdate(Long updateId) throws RemoteException {
        return commentDao.getCommentsByUpdate(updateId);
    }
}

