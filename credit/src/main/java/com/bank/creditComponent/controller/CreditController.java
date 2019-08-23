package com.bank.creditComponent.controller;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditInfo;
import com.bank.creditComponent.domain.CreditItem;
import com.bank.creditComponent.service.CreditService;
import com.bank.customerComponent.controller.CustomerController;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.productComponent.controller.ProductController;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreditController {

	@Autowired
	private ProductController productController;

	@Autowired
	private CustomerController customerController;

	@Autowired
	private CreditService creditService;

	private int creditID;

	public int createCredit(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO) {

		// Set new credit number
		int creditNumber = creditService.generateCreditNumber();

		// Creating product
		productController.createProduct(productDTO, creditNumber);

		// Creating consumer
		customerController.createCustomer(customerDTO, creditNumber);

		// Saving credit data
		creditService.saveCredit(creditDTO, creditNumber);

		//TODO check if everthing is correct
//		creditService.checkCredit(creditNumber);

		return creditNumber;
	}

	public List<CreditItem> getCredits() throws Exception {

		List<CreditItem> creditsInfoList = new ArrayList<>();

		// Getting all credits
		List<CreditDTO> creditList = creditService.getAllCredits();

		for (CreditDTO credit : creditList) {
			creditsInfoList.add(new CreditItem(new CreditInfo(credit)));
		}

		// Getting all customers
		List<CreditItem> customerList = customerController.getCustomers(creditsInfoList);

		// Getting all products
		List<CreditItem> productList = productController.getProducts(customerList);


		return productList;

	}


}
