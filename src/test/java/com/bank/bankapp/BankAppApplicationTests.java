package com.bank.bankapp;

import com.bank.bankapp.controller.BankController;
import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.controller.DatabaseController;
import com.bank.productComponent.domain.ProductDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAppApplicationTests {

	@Autowired
	BankController bankController;

	@Autowired
	DatabaseController databaseController;

	@Test
	public void createCreditTest() throws Exception{

		//Given
		CustomerDTO customerDTO = new CustomerDTO("John", "Doe", "80122485236");
		ProductDTO productDTO = new ProductDTO("Super Credit", 100000);
		CreditDTO creditDTO = new CreditDTO("Car Credit");

		//When
		bankController.createCredit(customerDTO, productDTO, creditDTO);

//		//Then
//		Assert.assertEquals();

		//Clean
		int creditID = databaseController.getAllCustomers().get(0).getCreditID();
		databaseController.deleteCredit(creditID);
		databaseController.deleteProduct(creditID);
		databaseController.deleteCredit(creditID);
	}

	@Test
	public void getCreditsTest() throws Exception{

		//Given
		CustomerDTO customerDTO = new CustomerDTO("John", "Doe", "80122485236");
		ProductDTO productDTO = new ProductDTO("Super Credit", 100000);
		CreditDTO creditDTO = new CreditDTO("Car Credit");
		bankController.createCredit(customerDTO, productDTO, creditDTO);

		//When
		List<CreditItem> creditsList = bankController.getCredits();
		int creditID = creditsList.get(0).getCreditNumber();
		System.out.println(creditID);

		//Then
		Assert.assertEquals(1, creditsList.size());
		Assert.assertEquals("John", creditsList.get(0).getCreditInfo().getCustomerDTO().getFirstName());
		Assert.assertEquals("Car Credit", creditsList.get(0).getCreditInfo().getCreditDTO().getCreditName());
		Assert.assertEquals("Super Credit", creditsList.get(0).getCreditInfo().getProductDTO().getProductName());

		//clean
		databaseController.deleteCredit(creditID);
		databaseController.deleteProduct(creditID);
		databaseController.deleteCustomer(creditID);
	}



	@Test
	public void contextLoads() {
	}





}
