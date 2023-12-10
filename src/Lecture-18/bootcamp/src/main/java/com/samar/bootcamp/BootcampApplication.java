package com.samar.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
		System.out.println("Hello Samar !!!");

		// Thread: tell this guy what to run
		// Runnable: It's a simple interface in java, which has a run()

		Thread t1 = new Thread(new MyRunnable("first"));
		t1.start(); // t1 is launched and now we move down
		// now, JVM will call its run() to start execution
		System.out.println("main thread in execution");
	}

}
