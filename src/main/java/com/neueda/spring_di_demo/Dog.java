package com.neueda.spring_di_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author danieldevlin
 * @date 28/04/2025
 * @project spring-di-demo
 */
@Component
public class Dog implements Pet {

    private static final Logger logger = LoggerFactory.getLogger(Dog.class);

    @Override
    public void feed() {
        logger.info("Feeding the dog 🐶");
    }
}
