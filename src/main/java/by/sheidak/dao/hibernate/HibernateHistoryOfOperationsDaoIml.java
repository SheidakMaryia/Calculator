package by.sheidak.dao.hibernate;

import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.entity.Operation;
import by.sheidak.entity.User;
import by.sheidak.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;

public class HibernateHistoryOfOperationsDaoIml implements HistoryOfOperationsDao {
    @Override
    public void saveOperations(Operation operation){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(operation);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> showHistory() {
        return null;
    }

    @Override
    public List<Operation> showHistoryByLogin(User user) {
        List<Operation> history = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Operation> query = session.createQuery("FROM Operation where user.id = :user", Operation.class);
            query.setParameter("user", user.getId());
            history = query.getResultList();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return history;
    }
}
