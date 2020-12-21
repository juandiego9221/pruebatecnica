package com.example.demo;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            clientRepository.save(new Client(1, "jdmm", "ape1", 28, new Date()));
        };
    }
}
