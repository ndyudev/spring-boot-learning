package com.ndyudev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.ndyudev.lab8",
        "com.ndyudev.lab7" // Scan thêm lab 7
})
@EntityScan({
        "com.ndyudev.lab8.model",
        "com.ndyudev.lab7.model" // Scan thêm Entity lab 7
})
@EnableJpaRepositories({
        "com.ndyudev.lab7.repository" // Scan thêm Repo lab 7
})
@Import(com.ndyudev.lab5.service.SessionService.class)
public class SpringBootMvcJava5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcJava5Application.class, args);
    }

}
