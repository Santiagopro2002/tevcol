package com.utc.tevcol;

import com.utc.tevcol.entity.AppUser;
import com.utc.tevcol.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TevcolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TevcolApplication.class, args);
    }

    @Bean
    CommandLineRunner initAdmin(AppUserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                AppUser u = new AppUser();
                u.setUsername("admin");
                u.setPasswordHash(encoder.encode("admin123"));
                u.setEnabled(true);
                repo.save(u);
                System.out.println(" Admin creado: admin / admin123");
            }
        };
    }
}