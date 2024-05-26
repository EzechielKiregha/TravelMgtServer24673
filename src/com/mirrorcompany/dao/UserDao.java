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
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

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
    
    public User findUserByEmail(String email) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from User u where u.email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            List<User> results = query.list();
            if (results != null && !results.isEmpty()) {
                return results.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
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
    
    public boolean registerUser(User user) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            
        }
        return false;
    }

//    public User findUserByEmail(String email) {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            Query query = session.createQuery("FROM User WHERE email = :email");
//            query.setParameter("email", email);
//            List<User> l = query.list();
//            System.out.println("Catch Yaaaaa...i THINK i FOUND IT.");
//            if (l != null){
//                System.out.println("Not Empty");
//            }
////                return l.get(0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    
    
    public boolean isEmailDuplicated(String email) {
        return findUserByEmail(email) != null;
    }

    public boolean isUsernameDuplicated(String username) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setParameter("username", username);
            System.out.println("Catch Yaaaaa...i THINK i FOUND IT.");
            return query.list() != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean verifyUser(Long userId, String code) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE userId = :userId AND verificationCode = :code");
            query.setParameter("userId", userId);
            query.setParameter("code", code);
            List<User> u = query.list();
            User user = u.get(0);
            if (user != null) {
                user.setVerificationCode(null);
                user.setStatus("Verified");
                session.update(user);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            
        }return false;
    }

    public boolean loginUser(String email, String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE email = :email AND password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            System.out.println("Log him in !!!");
            return query.list() != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String generateVerificationCode() {
        String code;
        Random rand = new Random();
        do {
            code = String.format("%06d", rand.nextInt(1000000));
        } while (isVerificationCodeDuplicated(code));
        return code;
    }

    public boolean isVerificationCodeDuplicated(String code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE verificationCode = :code");
            query.setParameter("code", code);
            return query.list() != null;
        } catch (Exception e) {
            e.printStackTrace();
        }return false;
    }
}
