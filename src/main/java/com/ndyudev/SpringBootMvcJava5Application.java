package com.ndyudev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        // Do trùng bean nên phải scan riêng
        "com.ndyudev.lab7"
})
@EntityScan(basePackages = "com.ndyudev.lab7.model")
@EnableJpaRepositories(basePackages = "com.ndyudev.lab7.repository")
@Import(com.ndyudev.lab5.service.SessionService.class)
public class SpringBootMvcJava5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcJava5Application.class, args);
    }

}
