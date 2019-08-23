package com.bank.creditComponent;

import com.bank.creditComponent.controller.CreditController;
import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.bank")
public class CreditComponent {

	@Autowired
	CreditController creditController;

	public int createCredit(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO) {
		return creditController.createCredit(customerDTO, productDTO, creditDTO);
	}

	public List<CreditItem> getCredits() throws Exception{
		return creditController.getCredits();
	}


	public static void main(String[] args) {
		SpringApplication.run(CreditComponent.class, args);
	}

}
