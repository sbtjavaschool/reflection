package ru.sbt.reflection.proxy;

import ru.sbt.reflection.proxy.dynamic.CachedInvocationHandler;
import ru.sbt.reflection.proxy.simple.*;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import static java.lang.ClassLoader.getSystemClassLoader;
import static ru.sbt.reflection.proxy.dynamic.CachedInvocationHandler.cache;

public class MainDynamic {
    public static void main(String[] args) {
        Calculator proxyCalc = cache(new CalculatorImpl());
        Loader loader = cache(new LoaderImpl());

        run(proxyCalc);
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
