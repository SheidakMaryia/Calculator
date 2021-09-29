package by.sheidak.services;

import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.entity.Operation;
import by.sheidak.entity.User;

import java.util.List;

public class HistoryOfOperations {
    private HistoryOfOperationsDao historyOfOperationsDao;

    public HistoryOfOperations(HistoryOfOperationsDao historyOfOperationsDao) {
        this.historyOfOperationsDao = historyOfOperationsDao;
    }

    public HistoryOfOperations() {}

    public HistoryOfOperationsDao getHistoryOfOperationsDao() {
        return historyOfOperationsDao;
    }

    public void setHistoryOfOperationsDao(HistoryOfOperationsDao historyOfOperationsDao) {
        this.historyOfOperationsDao = historyOfOperationsDao;
    }

    public List<Operation> showHistoryByLogin (User user){
        return historyOfOperationsDao.showHistoryByLogin(user);
    }

    public void addToHistory(Operation operation ){
        historyOfOperationsDao.saveOperations(operation );
    }

}
