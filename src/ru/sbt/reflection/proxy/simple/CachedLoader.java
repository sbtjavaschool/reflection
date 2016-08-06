package ru.sbt.reflection.proxy.simple;

import java.util.HashMap;
import java.util.Map;

public class CachedLoader implements Loader {
    private final Loader loader;
    private final Map<String, String> resultByArg = new HashMap<>();

    public CachedLoader(Loader loader) {
        this.loader = loader;
    }

    @Override
    public String load(int pageNumber, String url) {
        if (!resultByArg.containsKey(key(pageNumber, url))) {
            String result = loader.load(pageNumber, url);
            resultByArg.put(key(pageNumber, url), result);
        }

        return resultByArg.get(key(pageNumber, url));
    }

    private String key(int pageNumber, String url) {
        return pageNumber + "|" + url;
    }
}
