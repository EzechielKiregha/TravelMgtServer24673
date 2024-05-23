package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.MessageDao;
import com.mirrorcompany.community.model.Message;
import com.mirrorcompany.community.service.MessageService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    private MessageDao messageDao;

    public MessageServiceImpl() throws RemoteException {
        messageDao = new MessageDao();
    }

    @Override
    public void createMessage(Message message) throws RemoteException {
        messageDao.createMessage(message);
    }

    @Override
    public Message getMessageById(Long messageId) throws RemoteException {
        return messageDao.getMessageById(messageId);
    }

    @Override
    public List<Message> getAllMessages() throws RemoteException {
        return messageDao.getAllMessages();
    }

    @Override
    public void updateMessage(Message message) throws RemoteException {
        messageDao.updateMessage(message);
    }

    @Override
    public void deleteMessage(Long messageId) throws RemoteException {
        messageDao.deleteMessage(messageId);
    }

    @Override
    public List<Message> getMessagesByChat(Long chatId) throws RemoteException {
        return messageDao.getMessagesByChat(chatId);
    }

    @Override
    public List<Message> getMessagesByUser(Long userId) throws RemoteException {
        return messageDao.getMessagesByUser(userId);
    }
}

