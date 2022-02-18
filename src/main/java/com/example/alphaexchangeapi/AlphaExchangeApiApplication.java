package com.example.alphaexchangeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class AlphaExchangeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run( AlphaExchangeApiApplication.class,args );
    }

}
