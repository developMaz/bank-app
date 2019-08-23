package com.bank.customerComponent.controller;

import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.customerComponent.service.CustomerService;
import com.bank.databaseComponent.Exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerController {

	@Autowired
	CustomerService customerService;

	public void createCustomer(CustomerDTO customerDTO, int creditID) {
		customerService.createCustomer(customerDTO, creditID);
	}

	public List<CreditItem> getCustomers(List<CreditItem> creditItemList) throws CustomerNotFoundException {
		return customerService.getCustomers(creditItemList);
	}

	public List<CustomerDTO> getAllCustomers() {
		return customerService.getAllCustomers();
	}

}
