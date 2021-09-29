package by.sheidak.services;

import by.sheidak.entity.Operation;
import by.sheidak.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryOfOperationsTest {
    private final SessionFacade sessionFacade = new SessionFacade();

    @Before
    void initialization(){
        User user1 = new User("Masha", "mashasheidak", "masha");
        User user2 = new User("Masha2", "mashasheidak2", "masha2");

        List<Operation> operationsList = new ArrayList<>();

        //operationsList.add(11.0, 12.0, "addition", 23.0, user1);
    }

    @Test
    void showHistoryByLogin() {
    }

    @Test
    void addToHistory() {
    }
}