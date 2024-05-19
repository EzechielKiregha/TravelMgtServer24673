package com.mirrorcompany.community.service.impl;

import com.mirrorcompany.community.dao.ChatDao;
import com.mirrorcompany.community.model.Chat;
import com.mirrorcompany.community.service.ChatService;
import com.mirrorcompany.model.User;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatServiceImpl extends UnicastRemoteObject implements ChatService {

    private ChatDao chatDao;

    protected ChatServiceImpl() throws RemoteException {
        super();
        chatDao = new ChatDao();
    }

    @Override
    public void createChat(Chat chat) throws RemoteException {
        chatDao.createChat(chat);
    }

    @Override
    public Chat getChatById(Long chatId) throws RemoteException {
        return chatDao.getChatById(chatId);
    }

    @Override
    public List<Chat> getAllChats() throws RemoteException {
        return chatDao.getAllChats();
    }

    @Override
    public void updateChat(Chat chat) throws RemoteException {
        chatDao.updateChat(chat);
    }

    @Override
    public void deleteChat(Long chatId) throws RemoteException {
        chatDao.deleteChat(chatId);
    }

    @Override
    public void addParticipantToChat(Long chatId, User user) throws RemoteException {
        chatDao.addParticipantToChat(chatId, user);
    }

    @Override
    public void removeParticipantFromChat(Long chatId, User user) throws RemoteException {
        chatDao.removeParticipantFromChat(chatId, user);
    }
}
