package ru.sbt.reflection.proxy.simple;

import java.util.HashMap;
import java.util.Map;

public class CachedCalculator implements Calculator {
    private final Calculator calculator;
    private final Map<Integer, Integer> resultByArg = new HashMap<>();

    public CachedCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int arg) {
        if (!resultByArg.containsKey(arg)) {
            int result = calculator.calc(arg);
            resultByArg.put(arg, result);
        }

        return resultByArg.get(arg);
    }
}
