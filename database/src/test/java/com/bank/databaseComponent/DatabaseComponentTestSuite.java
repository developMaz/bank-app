package com.bank.databaseComponent;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.customerComponent.controller.CustomerController;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.Exceptions.CreditNotFoundException;
import com.bank.databaseComponent.Exceptions.CustomerNotFoundException;
import com.bank.databaseComponent.Exceptions.ProductNotFoundException;
import com.bank.databaseComponent.controller.DatabaseController;
import com.bank.productComponent.controller.ProductController;
import com.bank.productComponent.domain.ProductDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseComponentTestSuite {

	@Autowired
	DatabaseController databaseController;

	@Autowired
	CustomerController customerController;

	@Autowired
	ProductController productController;


	@Test
	public void createProductTest(){
		ProductDTO productDTO = new ProductDTO(12345, "CarCredit",300000);

		databaseController.createProduct(productDTO);

		//clean db
		try {
			databaseController.deleteProduct(12345);
		} catch (Exception e) {
			new ProductNotFoundException();
		}

	}

	@Test
	public void createCustomerTest(){
		CustomerDTO customerDTO = new CustomerDTO(12345, "John", "Doe", "12345678910");

		databaseController.createCustomer(customerDTO);

		//clean db
		try {
			databaseController.deleteCustomer(12345);
		} catch (Exception e) {
			new CustomerNotFoundException();
		}

	}

	@Test
	public void saveCreditTest(){
		CreditDTO creditDTO = new CreditDTO(12345,"CarCredit");

		databaseController.saveCredit(creditDTO);

		//clean db
		try {
			databaseController.deleteCredit(12345);
		} catch (Exception e) {
			new CreditNotFoundException();
		}

	}

	@Test
	public void findAndDeleteProductTest() throws Exception {
		ProductDTO productDTO = new ProductDTO(12345, "CarCredit",300000);
		databaseController.createProduct(productDTO);

		int creditID = productDTO.getCreditID();

		try {
			databaseController.deleteProduct(creditID);
		} catch (Exception e) {
			new ProductNotFoundException();
		}

	}

	@Test
	public void findAndDeleteCustomerTest() throws Exception {
		CustomerDTO customerDTO = new CustomerDTO(12345, "John", "Doe", "12345678910");
		databaseController.createCustomer(customerDTO);

		int creditID = customerDTO.getCreditID();

		try {
			databaseController.deleteCustomer(creditID);
		} catch (Exception e) {
			new CustomerNotFoundException();
		}
	}

	@Test
	public void findAndDeleteCredit() throws Exception {
		CreditDTO creditDTO = new CreditDTO(12345,"CarCredit");
		databaseController.saveCredit(creditDTO);

		int creditID = creditDTO.getCreditID();

		try {
			databaseController.deleteCredit(creditID);
		} catch (Exception e) {
			new CreditNotFoundException();
		}
	}

	@Test
	public void getProductsTest() {
		ProductDTO productDTO1 = new ProductDTO(12345, "CarCredit1",100000);
		ProductDTO productDTO2 = new ProductDTO(56478, "CarCredit2",200000);
		ProductDTO productDTO3 = new ProductDTO(10112, "CarCredit3",300000);

		databaseController.createProduct(productDTO1);
		databaseController.createProduct(productDTO2);
		databaseController.createProduct(productDTO3);

		int numberOfProducts = databaseController.getAllProducts().size();

		Assert.assertNotNull(numberOfProducts);
		Assert.assertEquals(3, numberOfProducts);

		//clean db
		try {
			databaseController.deleteProduct(12345);
			databaseController.deleteProduct(56478);
			databaseController.deleteProduct(10112);
		} catch (Exception e) {
			new ProductNotFoundException();
		}

	}

	@Test
	public void getCreditsTest() {
		CreditDTO creditDTO1 = new CreditDTO(12345,"CarCredit1");
		CreditDTO creditDTO2 = new CreditDTO(56478,"CarCredit2");

		databaseController.saveCredit(creditDTO1);
		databaseController.saveCredit(creditDTO2);

		int numberOfCredits = databaseController.getAllCredits().size();

		Assert.assertNotNull(numberOfCredits);
		Assert.assertEquals(2, numberOfCredits);

		//clean db
		try {
			databaseController.deleteCredit(12345);
			databaseController.deleteCredit(56478);
		} catch (Exception e) {
			new CreditNotFoundException();
		}

	}

	@Test
	public void getCustomerTest() {
		CustomerDTO customerDTO1 = new CustomerDTO(12345, "John", "Doe", "12345678910");
		CustomerDTO customerDTO2 = new CustomerDTO(56478, "Mary", "Doe", "23456789101");
		CustomerDTO customerDTO3 = new CustomerDTO(10112, "Albert", "Kettle", "34567891012");
		CustomerDTO customerDTO4 = new CustomerDTO(13145, "Steven", "Fry", "45678910123");


		databaseController.createCustomer(customerDTO1);
		databaseController.createCustomer(customerDTO2);
		databaseController.createCustomer(customerDTO3);
		databaseController.createCustomer(customerDTO4);

		int numberOfCustomers = databaseController.getAllCustomers().size();

		Assert.assertNotNull(numberOfCustomers);
		Assert.assertEquals(4, numberOfCustomers);

		//clean db
		try {
			databaseController.deleteCustomer(12345);
			databaseController.deleteCustomer(56478);
			databaseController.deleteCustomer(10112);
			databaseController.deleteCustomer(13145);
		} catch (Exception e) {
			new CustomerNotFoundException();
		}

	}

//	@Test
//	public void getCustomersTest() throws Exception{
//
//		CreditDTO creditDTO1 = new CreditDTO(12345,"CarCredit1");
//		CreditDTO creditDTO2 = new CreditDTO(56478,"CarCredit2");
//
//		List<CustomerDTO> customerDTOS = new ArrayList<>();
//		List<CreditItem> creditDTOS = new ArrayList<>();
//
//		creditDTOS.add(new CreditItem(new CreditInfo(creditDTO1)));
//		creditDTOS.add(new CreditItem(new CreditInfo(creditDTO2)));
//
//		List<CustomerDTO> newList = new ArrayList<>();
//
//		List<CreditItem> list = customerController.getCustomers(creditDTOS);
//		Assert.assertEquals(2, list.size());
//		List<CreditItem> list2 = productController.getProducts(list);
//
//		for (CreditItem item : list2) {
//			System.out.println("Begining: " + item);
//			System.out.println(item.getCreditNumber());
//			System.out.println(item.getCreditInfo().getCreditDTO().toString());
//			System.out.println(item.getCreditInfo().getCustomerDTO().toString());
//			System.out.println(item.getCreditInfo().getProductDTO().toString());
//		}
//
//	}
}
