package com.neueda.spring_di_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author danieldevlin
 * @date 28/04/2025
 * @project spring-di-demo
 */

@Service
public class PetService {

    private final Pet cat;
    private final Pet dog;

    @Autowired
    public PetService(@Qualifier("cat") Pet cat, @Qualifier("dog") Pet dog) {
        this.cat = cat;
        this.dog = dog;
    }

    // Dynamically returns the right Pet based on input
    public Pet getPet(String petType) {
        return switch (petType.toLowerCase()) {
            case "cat" -> cat;
            case "dog" -> dog;
            default -> throw new IllegalArgumentException("No such pet: " + petType);
        };
    }
}