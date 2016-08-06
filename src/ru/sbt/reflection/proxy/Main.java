package ru.sbt.reflection.proxy;

import ru.sbt.reflection.proxy.simple.CachedCalculator;
import ru.sbt.reflection.proxy.simple.Calculator;
import ru.sbt.reflection.proxy.simple.SuperSlowCalculator;

public class Main {
    public static void main(String[] args) {
//        run(new CachedCalculator(new CalculatorImpl()));
        run(new CachedCalculator(new SuperSlowCalculator()));
    }

    private static void run(Calculator calculator) {
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(1));
    }
}
