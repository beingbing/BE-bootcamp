package com.samar.bootcamp.WebCrawler;

import java.util.List;

public class WebClient {

    public List<URL> parseAndGet(URL url) {
        // parsing logic
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        return url.getInternalURLs();
    }
}
