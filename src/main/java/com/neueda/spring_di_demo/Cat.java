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
public class Cat implements Pet{
    // This is a logger for the Cat class
    private final Logger logger = LoggerFactory.getLogger(Cat.class);

    @Override
    public void feed() {
        logger.info("Feeding the cat 🐱");
    }

}
