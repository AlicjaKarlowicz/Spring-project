package io.lab.springdatalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Collections;

@SpringBootApplication
public class SpringdataLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataLabApplication.class, args);
    }


}
