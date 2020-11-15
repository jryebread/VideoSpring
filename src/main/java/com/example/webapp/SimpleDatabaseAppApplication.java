package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SimpleDatabaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDatabaseAppApplication.class, args);
	}

}
