package by.sheidak.dao;
import by.sheidak.entity.*;

import javax.transaction.SystemException;
import java.util.List;

public interface HistoryOfOperationsDao {

    void saveOperations (Operation operation);

    List<Operation> showHistory();

    List<Operation> showHistoryByLogin(User user);
}
