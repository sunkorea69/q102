package com.psc.example.q102;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class Q102Application {

    public static void main(String[] args) {
        SpringApplication.run(Q102Application.class, args);
    }

}
