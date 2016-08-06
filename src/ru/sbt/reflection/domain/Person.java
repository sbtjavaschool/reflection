package ru.sbt.reflection.domain;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public List<String> getFriendNames(){
        return emptyList();
    }

    public int getAge() {
        return age;
    }

    private void sayName() {
        System.out.println(name);
    }
}