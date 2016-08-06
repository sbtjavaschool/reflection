package ru.sbt.reflection.proxy.dynamic;

import ru.sbt.reflection.proxy.simple.Loader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

import static java.lang.ClassLoader.getSystemClassLoader;
import static java.util.Arrays.asList;

public class CachedInvocationHandler implements InvocationHandler {
    private final Map<Object, Object> resultByArg = new HashMap<>();
    private final Object delegate;

    public static <T> T cache(Object delegate) {
        return (T) Proxy.newProxyInstance(getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate)
        );
    }

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) return invoke(method, args);

        if (!resultByArg.containsKey(key(method, args))) {
            System.out.println("Delegation of " + method.getName());
            Object result = invoke(method, args);
            resultByArg.put(key(method, args), result);
        }

        return resultByArg.get(key(method, args));
    }

    private Object invoke(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(delegate, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Impossible");
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private Object key(Method method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);
        key.addAll(asList(args));
        return key;
    }
}
