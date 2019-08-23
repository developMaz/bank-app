package com.bank.customerComponent;

import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.controller.CustomerController;
import com.bank.customerComponent.domain.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.bank")
public class CustomerComponent{

	@Autowired
	CustomerController customerController;

	public void createCustomer(CustomerDTO customerDTO, int creditID) {
		customerController.createCustomer(customerDTO, creditID);
	}

	public List<CreditItem> getCustomers(List<CreditItem> creditItemList) throws Exception {
		return customerController.getCustomers(creditItemList);
	}


	public static void main(String[] args) {
		SpringApplication.run(CustomerComponent.class, args);
	}

}
