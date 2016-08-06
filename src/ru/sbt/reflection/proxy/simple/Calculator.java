package ru.sbt.reflection.proxy.simple;

import ru.sbt.reflection.proxy.dynamic.Cache;

public interface Calculator {
    @Cache
    int calc(int arg);
}
