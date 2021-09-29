package by.sheidak.dao.inMemory;
import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.entity.*;

import java.util.ArrayList;
import java.util.List;

public class HistoryOperationsDaoImp implements HistoryOfOperationsDao {
    private static List<Operation> historyOfOperations = new ArrayList<>();

    @Override
    public void saveOperations(Operation operation) {
        historyOfOperations.add(operation);
    }


    @Override
    public List<Operation> showHistory() {
        return historyOfOperations;
    }

    @Override
    public List<Operation> showHistoryByLogin(User user) {
        List<Operation> historyByLogin = new ArrayList<>();
        for (Operation operation: historyOfOperations){
            if (operation.getUser().getLogin().equals(user.getLogin())){
                historyByLogin.add(operation);
            }
        }
        return historyByLogin;
    }
}
