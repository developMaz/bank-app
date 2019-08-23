package com.bank.productComponent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank")
public class ProductComponent {

	public static void main(String[] args) {
		SpringApplication.run(ProductComponent.class, args);
	}

}
