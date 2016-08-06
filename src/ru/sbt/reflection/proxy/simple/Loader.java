package ru.sbt.reflection.proxy.simple;

import ru.sbt.reflection.proxy.dynamic.Cache;

public interface Loader {
    @Cache
    String load(int pageNumber, String url);

    String load(int pageNumber);
}
