package by.sheidak.dao.hibernate;

import by.sheidak.dao.UserDao;
import by.sheidak.entity.User;
import by.sheidak.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction =  session.beginTransaction();
            session.save(user);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            list = session.createQuery("FROM User", User.class).getResultList();
            transaction.commit();

        }catch (HibernateException e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserByLogin(User user) {
        User userByLogin = new User();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User where login = :login", User.class);
            query.setParameter("login", user.getLogin());
            userByLogin = query.getSingleResult();
            transaction.commit();

        } catch (HibernateException e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return userByLogin;
    }
}
