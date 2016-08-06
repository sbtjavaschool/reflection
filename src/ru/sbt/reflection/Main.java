package ru.sbt.reflection;

import ru.sbt.reflection.domain.Person;
import ru.sbt.reflection.utils.ReflectionUtils;

public class Main {
    public static void main(String[] args) {
        ReflectionUtils.printAllMethods(new Person("Alex", 1));


//        hierarchy();
    }

    private static void hierarchy() {
        ReflectionUtils.printHierarchy("Hello");
        ReflectionUtils.printHierarchy(1);
        ReflectionUtils.printHierarchy(new Person("Alex", 1));
    }
}