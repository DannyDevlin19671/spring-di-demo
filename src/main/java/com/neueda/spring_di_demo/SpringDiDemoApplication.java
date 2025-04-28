package com.neueda.spring_di_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@SpringBootApplication
public class SpringDiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PetService petService, Person person) {
		return args -> {
			// dynamically choose pet based on argument
			String petChoice = args.length > 0 ? args[0] : "cat";

			Pet chosenPet = petService.getPet(petChoice);
			person.setPet(chosenPet);

			person.feedPet();
		};
	}

}
