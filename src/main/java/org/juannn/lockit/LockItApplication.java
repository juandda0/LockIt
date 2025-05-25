package org.juannn.lockit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;

@SpringBootApplication
public class LockItApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockItApplication.class, args);
        SecureRandom random = new SecureRandom();
        int password = random.nextInt(1000000000);
        System.out.println("Contraseña: " + password);

    }

}
