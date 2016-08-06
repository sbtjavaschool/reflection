package ru.sbt.reflection.proxy.simple;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int arg) {
        System.out.println("calc" + arg);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return arg * 5;
    }
}
