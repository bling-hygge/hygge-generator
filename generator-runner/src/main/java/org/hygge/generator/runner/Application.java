package org.hygge.generator.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.hygge.generator"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}