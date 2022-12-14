package com.iti0207.parkla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class ParklaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParklaApplication.class, args);
    }

}
