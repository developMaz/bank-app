package com.bank.databaseComponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank")
public class DatabaseComponent {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseComponent.class, args);
	}

}
