package by.sheidak.services.dependencies;

import by.sheidak.dao.hibernate.HibernateHistoryOfOperationsDaoIml;
import by.sheidak.dao.hibernate.HibernateUserDaoImpl;
import by.sheidak.dao.inMemory.AddressDaoImpl;
import by.sheidak.dao.inMemory.HistoryOperationsDaoImp;
import by.sheidak.dao.inMemory.TelephoneDaoImpl;
import by.sheidak.dao.inMemory.UsersDaoImpl;
import by.sheidak.entity.Address;
import by.sheidak.services.*;

public class DependenciesService {
    //save all inf in memory of program
    public static final Calculation calculation = new Calculation(new HistoryOperationsDaoImp());
    public static final Authorization authorization = new Authorization(new UsersDaoImpl());
    public static final Registration registration = new Registration(new UsersDaoImpl());
    public static final HistoryOfOperations historyOfOperations = new HistoryOfOperations(new HistoryOperationsDaoImp());
    public static final AddressService address = new AddressService(new AddressDaoImpl());
    public static final TelephoneService telephone = new TelephoneService(new TelephoneDaoImpl());



    //save all inf in data base
//    public static final Calculation calculation = new Calculation(new JDBCHistoryOfOperationsDaoImpl());
//    public static final Authorization authorization = new Authorization(new JDBCUUsersDaoImpl());
//    public static final Registration registration = new Registration(new JDBCUUsersDaoImpl());
//    public static final HistoryOfOperations historyOfOperations = new HistoryOfOperations(new JDBCHistoryOfOperationsDaoImpl());

    //Hibernate
//    public static final Calculation calculation = new Calculation(new HibernateHistoryOfOperationsDaoIml());
//    public static final Authorization authorization = new Authorization(new HibernateUserDaoImpl());
//    public static final Registration registration = new Registration(new HibernateUserDaoImpl());
//    public static final HistoryOfOperations historyOfOperations = new HistoryOfOperations(new HibernateHistoryOfOperationsDaoIml());


}
