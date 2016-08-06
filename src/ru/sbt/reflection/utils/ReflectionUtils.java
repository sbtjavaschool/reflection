package ru.sbt.reflection.utils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class ReflectionUtils {
    public static void printHierarchy(Object o){
        System.out.println("_____________________");
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }
    }

    public static List<String> printAllMethods(Object o){
        Class<?> clazz = o.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        return emptyList();
    }
}
