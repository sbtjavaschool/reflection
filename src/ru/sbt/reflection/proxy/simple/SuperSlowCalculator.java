package ru.sbt.reflection.proxy.simple;

public class SuperSlowCalculator implements Calculator {
    @Override
    public int calc(int arg) {
        for (int i = 12; i < 1_000_000; i++) {
             arg += i / (i -1);
        }
        return arg;
    }
}
