package com.bank.databaseComponent.controller;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.Exceptions.CreditNotFoundException;
import com.bank.databaseComponent.Exceptions.CustomerNotFoundException;
import com.bank.databaseComponent.Exceptions.ProductNotFoundException;
import com.bank.databaseComponent.mapper.DatabaseMapper;
import com.bank.databaseComponent.service.CreditDBservice;
import com.bank.databaseComponent.service.CustomerDBservice;
import com.bank.databaseComponent.service.ProductDBservice;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DatabaseController {

	@Autowired
	DatabaseMapper databaseMapper;

	@Autowired
	ProductDBservice productDbService;

	@Autowired
	CustomerDBservice customerDBservice;

	@Autowired
	CreditDBservice creditDBservice;

	public List<ProductDTO> getAllProducts() {
		return databaseMapper.mapToProductDTOList(productDbService.getAllProducts());
	}

	public List<CreditDTO> getAllCredits() {
		return databaseMapper.mapToCreditDTOList(creditDBservice.getAllCredits());
	}

	public List<CustomerDTO> getAllCustomers() {
		return databaseMapper.mapToCustomerDTOList(customerDBservice.getAllCustomers());
	}

	public void createProduct(ProductDTO productDTO) {
		productDbService.createProduct(databaseMapper.mapToProductDB(productDTO));
	}

	public void createCustomer(CustomerDTO customerDTO) {
		customerDBservice.createCustomer(databaseMapper.mapToCustomerDB(customerDTO));

	}

	public void saveCredit(CreditDTO creditDTO) {
		creditDBservice.saveCredit(databaseMapper.mapToCreditDB(creditDTO));
	}

	public void deleteProduct(final int creditID) throws Exception {
		productDbService.deleteProduct(productDbService.getProductById(creditID).orElseThrow(ProductNotFoundException::new));
	}

	public void deleteCustomer(final int creditID) throws Exception {
		customerDBservice.deleteCustomer(customerDBservice.getCustomerById(creditID).orElseThrow(CustomerNotFoundException::new));
	}

	public void deleteCredit(final int creditID) throws Exception {
		creditDBservice.deleteCredit(creditDBservice.getCreditById(creditID).orElseThrow(CreditNotFoundException::new));
	}

	public ProductDTO getProductByCreditID(int crediID) throws Exception {
		return databaseMapper.mapToProductDTO(productDbService.getProductById(crediID).orElseThrow(ProductNotFoundException::new));
	}

	public void getCreditByCreditID() {

	}

	public CustomerDTO getCustomerByCreditID(int creditID) throws Exception{
		return databaseMapper.mapToCustomerDTO(customerDBservice.getCustomerById(creditID).orElseThrow(CustomerNotFoundException::new));
	}
}
