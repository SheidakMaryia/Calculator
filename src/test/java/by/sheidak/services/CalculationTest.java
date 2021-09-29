package by.sheidak.services;

import by.sheidak.entity.Operation;
import by.sheidak.entity.User;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    private final SessionFacade sessionFacade = new SessionFacade();

    @Test
    void getResult() {

        double num1 = 12.0;
        double num2 = 13.0;
        String typeOfOperation = "addition";

        Operation result = sessionFacade.calculate(num1, num2, typeOfOperation);
        double actual = result.getResult();
        double expected = 25.0;

        assertEquals(expected, actual);
    }
}