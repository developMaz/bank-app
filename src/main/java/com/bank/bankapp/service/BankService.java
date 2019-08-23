package com.bank.bankapp.service;

import com.bank.creditComponent.controller.CreditController;
import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

	@Autowired
	private CreditController creditController;

	public void createCredit(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO){
		creditController.createCredit(customerDTO, productDTO, creditDTO);
	}

	public List<CreditItem> getCredits() throws Exception {
		return creditController.getCredits();
	}
}
