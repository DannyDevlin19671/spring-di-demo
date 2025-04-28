package com.neueda.spring_di_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author danieldevlin
 * @date 28/04/2025
 * @project spring-di-demo
 */

@Component
public class Person {
    private static final Logger logger = LoggerFactory.getLogger(Person.class);
    private Pet pet;

    // Setter Injection allows dynamic assignment at runtime
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void feedPet() {
        if (pet == null) {
            logger.warn("No pet assigned yet!");
        } else {
            logger.info("Person is feeding the pet:");
            pet.feed();
        }
    }
}
