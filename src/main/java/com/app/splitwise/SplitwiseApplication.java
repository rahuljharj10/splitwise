package com.app.splitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Splitwise Spring Boot application.
 */
@SpringBootApplication
public class SplitwiseApplication {

    /**
     * Bootstraps the Spring application context.
     *
     * @param args JVM startup arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

}
