/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirrorcompany.dao;

/**
 *
 * @author ekire
 */
import com.mirrorcompany.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public UserDao() {
    }

    public boolean addUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return false;
    }

//    public User findUserById(Long userId) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            return (User) session.get(User.class, userId);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    public User findUserByEmail(User user) {
        Session session = null;
        String email = user.getEmail();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from User u where u.email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            List<User> results = query.list();
            if (results != null && !results.isEmpty()) {
                user = results.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }


    public boolean updateUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return false;
    }

    public boolean deleteUser(User user) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> findAllUsers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("FROM User").list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
