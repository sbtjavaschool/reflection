package ru.sbt.reflection.proxy;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int arg) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return arg * 5;
    }
}
