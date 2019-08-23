package com.bank.creditComponent;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.service.CreditService;
import com.bank.customerComponent.controller.CustomerController;
import com.bank.databaseComponent.controller.DatabaseController;
import com.bank.productComponent.controller.ProductController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreditComponentTestSuite {

	@Autowired
	CreditService creditService;

	@Autowired
	DatabaseController databaseController;

	@Autowired
	CustomerController customerController;

	@Autowired
	ProductController productController;

	@Test
	public void creditTest() throws Exception{
		//Given
		int creditNumber = 12345;
		CreditDTO creditDTO = new CreditDTO("credit");

		//When
		creditService.saveCredit(creditDTO, creditNumber);
		List<CreditDTO> list = creditService.getAllCredits();

		//Then
		Assert.assertEquals(1, list.size());
		Assert.assertEquals("credit",list.get(0).getCreditName());

		//Clean
		databaseController.deleteCredit(creditNumber);
	}

	@Test
	public void getCreditsTest() throws Exception{

/*
		//Given
		CustomerDTO customerDTO1 = new CustomerDTO(12345, "John", "Doe", "12345678910");
		CustomerDTO customerDTO2 = new CustomerDTO(56478, "Mary", "Doe", "23456789101");
		CustomerDTO customerDTO3 = new CustomerDTO(10112, "Albert", "Kettle", "34567891012");
		CustomerDTO customerDTO4 = new CustomerDTO(13145, "Steven", "Fry", "45678910123");
		databaseController.createCustomer(customerDTO1);
		databaseController.createCustomer(customerDTO2);
		databaseController.createCustomer(customerDTO3);
		databaseController.createCustomer(customerDTO4);

		ProductDTO productDTO1 = new ProductDTO(12345, "CarCredit1",100000);
		ProductDTO productDTO2 = new ProductDTO(56478, "CarCredit2",200000);
		ProductDTO productDTO3 = new ProductDTO(10112, "CarCredit3",300000);
		databaseController.createProduct(productDTO1);
		databaseController.createProduct(productDTO2);
		databaseController.createProduct(productDTO3);

		CreditDTO creditDTO1 = new CreditDTO(12345,"CarCredit1");
		CreditDTO creditDTO2 = new CreditDTO(56478,"CarCredit2");
		databaseController.saveCredit(creditDTO1);
		databaseController.saveCredit(creditDTO2);

		List<CreditItem> creditDTOS = new ArrayList<>();

		creditDTOS.add(new CreditItem(new CreditInfo(creditDTO1)));
		creditDTOS.add(new CreditItem(new CreditInfo(creditDTO2)));

		List<CustomerDTO> newList = new ArrayList<>();

		List<CreditItem> list = customerController.getCustomers(creditDTOS);
		Assert.assertEquals(2, list.size());
		List<CreditItem> list2 = productController.getProducts(list);

		for (CreditItem item : list2) {
			System.out.println("Begining: " + item);
			System.out.println(item.getCreditNumber());
			System.out.println(item.getCreditInfo().getCreditDTO().toString());
			System.out.println(item.getCreditInfo().getCustomerDTO().toString());
			System.out.println(item.getCreditInfo().getProductDTO().toString());
		}


*/
	}
}
