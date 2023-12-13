package com.samar.bootcamp.WebCrawler;

import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final URL assignedURL;
    private final Set<String> pickedUrls;
    /*  1. if set doesn't contain URL
     *  2. crawl
     *  3. add to set
     * */
    // racing condition can happen in 'crawl' step
    private final WebClient webClient;
    private final Object lock;
    private final BlockingQueue<URL> urlsToProcess; // blocking-queue is a thread safe data-structure

    public Worker(URL assignedURL, Set<String> pickedUrls, WebClient webClient, Object lock, BlockingQueue<URL> urlsToProcess) {
        this.assignedURL = assignedURL;
        this.pickedUrls = pickedUrls;
        this.webClient = webClient;
        this.lock = lock;
        this.urlsToProcess = urlsToProcess;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (pickedUrls.contains(assignedURL.getName())) return;
            pickedUrls.add(assignedURL.getName());
        }

        // Crawling Job
        System.out.println(Thread.currentThread().getId() + " crawling " + assignedURL.getName() + " ...");

        for (URL url : webClient.parseAndGet(assignedURL)) {
            try {
                this.urlsToProcess.put(url);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
