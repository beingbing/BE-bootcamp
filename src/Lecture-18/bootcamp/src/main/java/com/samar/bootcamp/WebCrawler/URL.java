package com.samar.bootcamp.WebCrawler;

import java.util.ArrayList;
import java.util.List;

public class URL {
    private final String name;
    private final List<URL> internalURLs;

    public URL(String name) {
        this.name = name;
        this.internalURLs = new ArrayList<>();
    }

    public void addURL(URL url) {
        this.internalURLs.add(url);
    }

    public String getName() {
        return name;
    }

    public List<URL> getInternalURLs() {
        return this.internalURLs;
    }


}
