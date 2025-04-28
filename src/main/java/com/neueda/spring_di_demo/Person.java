package com.neueda.spring_di_demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author danieldevlin
 * @date 28/04/2025
 * @project spring-di-demo
 */

@Component
public class Person {
    private final Pet pet;

    // Constructor injection is used to inject
    // the Pet dependency into the Person class
    public Person(@Qualifier("dog") Pet pet) {
        this.pet = pet;
    }

    // This method uses the injected Pet instance
    public void feedPet() {
        pet.feed();
    }
}
