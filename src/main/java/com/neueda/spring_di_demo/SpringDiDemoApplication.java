package com.neueda.spring_di_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDiDemoApplication {

	public static void main(String[] args) {
		// Start the Spring application
		ConfigurableApplicationContext context = SpringApplication.run(SpringDiDemoApplication.class, args);

		// ❗ Alternative way (not recommended for normal apps):
		// We could manually fetch the Person bean from the context and call the method.
		// This works, but breaks the Dependency Injection principle slightly,
		// and couples our main method tightly to the Spring container.

		// Person person = context.getBean(Person.class);
		// person.feedPet();
	}

	@Bean
	public CommandLineRunner commandLineRunner(Person person) {
		// Using CommandLineRunner is a clean way to run logic after the application starts.
		// Spring automatically injects the Person object for us, following Dependency Injection (DI) principles.
		// This keeps the code loosely coupled, easier to test, and doesn't manually pull beans from the context.
		// It's the recommended approach for small startup tasks in Spring Boot applications.
		return args -> {
			person.feedPet();
		};
	}

}
