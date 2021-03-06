
package com.example;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServer {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestServer.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "4200"));
        app.run(args);
    }

}
