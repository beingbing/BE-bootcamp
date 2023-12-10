package com.samar.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootcampApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(BootcampApplication.class, args);
        System.out.println("Hello Samar !!!");

        // Thread: tell this guy what to run
        // Runnable: It's a simple interface in java, which has a run()

        Thread t1 = new Thread(new MyRunnable("first"));
        Thread t2 = new Thread(new MyRunnable("Second"));
        Thread t3 = new Thread(new MyRunnable("Third"));
        t1.start(); // t1 is launched and now we move down
        // now, JVM will call its run() to start execution
        t2.start();
        t3.start();
        t1.join(); // it will make your current thread wait until t1 is over
        // it is like a blocking call

        System.out.println("main thread in execution");
    }

	/*
    * You can see the difference in order of logs printed and the order
    * in which they were written -
    * Hello Samar !!!
    * first
    * Second
    * Second
    * Second
    * Second
    * Second
    * Second
    * Second
    * Second
    * Second
    * Second
    * main thread in execution
    * first
    * first
    * first
    * first
    * first
    * first
    * first
    * first
    * first
    * Third
    * Third
    * Third
    * Third
    * Third
    * Third
    * Third
    * Third
    * Third
    * Third
    */

    /*
    * You can see the difference after adding t1.join().
    * main thread got completed only after t1 is completed, although
    * definitely not immediately.
    *   Hello Samar !!!
        first
        first
        first
        first
        first
        Second
        Second
        Second
        Second
        Second
        Second
        Second
        Second
        Second
        Second
        first
        first
        first
        first
        Third
        first
        Third
        Third
        Third
        Third
        Third
        Third
        Third
        Third
        Third
        main thread in execution
    * */

}
