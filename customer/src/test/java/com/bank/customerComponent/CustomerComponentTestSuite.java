package com.bank.customerComponent;

import com.bank.customerComponent.controller.CustomerController;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.controller.DatabaseController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerComponentTestSuite {

	@Autowired
	CustomerController customerController;

	@Autowired
	DatabaseController databaseController;


	@Test
	public void customerTest(){

		CustomerDTO customer = new CustomerDTO("John", "Doe", "12345678910");

		Assert.assertEquals("John", customer.getFirstName());
		Assert.assertEquals("Doe", customer.getSecondName());
		Assert.assertEquals("12345678910", customer.getPesel());
	}

	@Test
	public void getCustomersTest() throws Exception{

		CustomerDTO customerDTO1 = new CustomerDTO(12345, "John", "Doe", "12345678910");
		CustomerDTO customerDTO2 = new CustomerDTO(56478, "Mary", "Doe", "23456789101");
		CustomerDTO customerDTO3 = new CustomerDTO(10112, "Albert", "Kettle", "34567891012");
		CustomerDTO customerDTO4 = new CustomerDTO(13145, "Steven", "Fry", "45678910123");

		databaseController.createCustomer(customerDTO1);
		databaseController.createCustomer(customerDTO2);
		databaseController.createCustomer(customerDTO3);
		databaseController.createCustomer(customerDTO4);

//		CreditDTO creditDTO1 = new CreditDTO(12345,"CarCredit1");
//		CreditDTO creditDTO2 = new CreditDTO(56478,"CarCredit2");
//
//		List<CustomerDTO> customerDTOS = new ArrayList<>();
//		List<CreditDTO> creditDTOS = new ArrayList<>();

//		customerDTOS.add(customerDTO1);
//		customerDTOS.add(customerDTO2);
//		customerDTOS.add(customerDTO3);
//		customerDTOS.add(customerDTO4);

//		creditDTOS.add(creditDTO1);
//		creditDTOS.add(creditDTO2);
//
//		List<CustomerDTO> newList = new ArrayList<>();
//
//		List<CustomerDTO> list = customerController.getCustomers(creditDTOS);
//
//		Assert.assertEquals(2, list.size());


	}
}
