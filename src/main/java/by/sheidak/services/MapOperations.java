package by.sheidak.services;

import by.sheidak.services.operations.*;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {
    public static final Map<String, MathOperation> MAP_OPERATION = new HashMap();

    static{
        MAP_OPERATION.put("addition", new Addition());
        MAP_OPERATION.put("subtraction", new Subtraction());
        MAP_OPERATION.put("multiplication", new Multiplication());
        MAP_OPERATION.put("division", new Division());
    }
}
