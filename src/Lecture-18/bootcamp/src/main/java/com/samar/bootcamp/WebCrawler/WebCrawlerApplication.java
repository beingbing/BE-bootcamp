package com.samar.bootcamp.WebCrawler;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class WebCrawlerApplication {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);
    // JVM's thread pool -> executor-service

    private static final BlockingQueue<URL> urlsToProcess = new LinkedBlockingQueue<>();

    private static URL getSeed() {
        URL url = new URL("apple.com");
        URL url1 = new URL("apple.com/i-phone-15");
        URL url2 = new URL("apple.com/products");
        URL url3 = new URL("apple.com/i-phones");
        URL url4 = new URL("apple.com/i-phone-11");
        URL url5 = new URL("apple.com/i-phone-11/pro");
        URL url6 = new URL("apple.com/i-phone-11/mini");
        url6.addURL(url5);
        url4.addURL(url6);
        url3.addURL(url4);url3.addURL(url6);
        url1.addURL(url2);url1.addURL(url5);
        url2.addURL(url5);url2.addURL(url4);
        url.addURL(url1);url.addURL(url2);url.addURL(url3);url.addURL(url4);
        return url;
    }

    public static void main(String[] args) throws InterruptedException {
        URL seed = getSeed();
        urlsToProcess.put(seed);
        Set<String> pickedURLs = new HashSet<>();
        WebClient webClient = new WebClient();
        Object lock = new Object();
        while (true) {
            URL currentURL = urlsToProcess.take();
            executorService.submit(new Worker(currentURL, pickedURLs, webClient, lock, urlsToProcess));
        }
    }

}
