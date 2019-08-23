package com.bank.bankapp.controller;

import com.bank.bankapp.service.BankService;
import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankController {

	@Autowired
	private BankService bankService;

	public void createCredit(CustomerDTO customerDTO, ProductDTO productDTO, CreditDTO creditDTO){
		bankService.createCredit(customerDTO, productDTO, creditDTO);
	}

	public List<CreditItem> getCredits() throws Exception{
		return bankService.getCredits();
	}
}
