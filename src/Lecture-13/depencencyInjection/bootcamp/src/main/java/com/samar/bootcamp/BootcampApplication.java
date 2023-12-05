package com.samar.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/*
	There are two different types of runners.
	ApplicationRunner: gives ApplicationArguments to work upon
	CommandLineRunner: gives String command line arguments to work upon

	Runners are methods that framework will
	call as soon as SpringApplication.run() is done execution.

	Why we felt the need to use it here ?
	because, we need a place where we do not need to define a field static to work upon.

 */
@SpringBootApplication
public class BootcampApplication implements ApplicationRunner {

	@Autowired
	private Notification notification;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootcampApplication.class, args);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("Hello Samar !!!");

//		MessageService messageService = new Whatsapp();
//		Notification notification = new Notification(messageService);
		// give responsibility of creating notification service also to spring
//		Notification notification = new Notification();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		notification.sendMessage("Hi");
		notification.sendMessage("Hello");
	}
}
