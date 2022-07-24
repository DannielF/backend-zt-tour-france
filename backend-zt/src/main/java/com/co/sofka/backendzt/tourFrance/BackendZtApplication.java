package com.co.sofka.backendzt.tourFrance;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Tour france spring boot application
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Tour France", version = "1.0", description = "Documentation APIs v1.0"))
public class BackendZtApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendZtApplication.class, args);
    }

}
