package by.sheidak.services;

import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.entity.Operation;
import by.sheidak.services.operations.MathOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

public class Calculation {
    private HistoryOfOperationsDao historyOfOperationsDao;

    private final Logger logger = LoggerFactory.getLogger(SessionFacade.class.getName());

    static double result = 0;


    public Calculation(HistoryOfOperationsDao historyOfOperationsDao) {
        this.historyOfOperationsDao = historyOfOperationsDao;
    }

    public Calculation() {}

    public HistoryOfOperationsDao getHistoryOfOperationsDao() {
        return historyOfOperationsDao;
    }

    public void setHistoryOfOperationsDao(HistoryOfOperationsDao historyOfOperationsDao) {
        this.historyOfOperationsDao = historyOfOperationsDao;
    }

    public Operation getResult(double num1, double num2, String operation){
        if (MapOperations.MAP_OPERATION.containsKey(operation)){
            MathOperation mathOp = MapOperations.MAP_OPERATION.get(operation);
            result = mathOp.getCalc(num1, num2);
            BigDecimal resultBD = new BigDecimal(result);
            resultBD = resultBD.setScale(3, RoundingMode.DOWN);
            result = resultBD.doubleValue();
            logger.info("Successful request to operation ({}) with num ({},{}) and result({}).", operation, num1, num2, result);
        }
        return new Operation(num1, num2, operation, result);
    }
}
