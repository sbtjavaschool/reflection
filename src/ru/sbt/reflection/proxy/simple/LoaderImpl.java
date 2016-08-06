package ru.sbt.reflection.proxy.simple;

public class LoaderImpl implements Loader {
    @Override
    public String load(int pageNumber, String url) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pageNumber + " " + url;
    }
}
