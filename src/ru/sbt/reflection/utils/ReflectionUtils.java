package ru.sbt.reflection.utils;

import ru.sbt.reflection.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class ReflectionUtils {
    public static void printHierarchy(Object o) {
        System.out.println("_____________________");
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }
    }

    public static List<String> printAllMethods(Object o) {
        Class<?> clazz = o.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        return emptyList();
    }

    public static void invokeAllGeters(Object o) {

    }

    public static void invokeMethod(Object o, String methodName) {
        Class<?> clazz = o.getClass();
        try {
            Method method = clazz.getMethod(methodName);
            if (method.getParameterCount() > 0) {
                throw new IllegalArgumentException("Method " + methodName + " should have exact 0 params");
            }
            if (method.getReturnType() == void.class)

            method.invoke(o);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Exception during reflection access", e);
        }
    }
}
