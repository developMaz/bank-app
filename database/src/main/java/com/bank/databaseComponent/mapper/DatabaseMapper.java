package com.bank.databaseComponent.mapper;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.domain.CreditDB;
import com.bank.databaseComponent.domain.CustomerDB;
import com.bank.databaseComponent.domain.ProductDB;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseMapper {

	//map object from object's module to database object

	public ProductDB mapToProductDB(final ProductDTO productDTO) {
		return new ProductDB(
				productDTO.getCreditID(),
				productDTO.getProductName(),
				productDTO.getProductValue());
	}

	public ProductDTO mapToProductDTO(final ProductDB productDB) {
		return new ProductDTO(
				productDB.getId(),
				productDB.getProductName(),
				productDB.getValue());
	}

	public CustomerDB mapToCustomerDB(final CustomerDTO customerDTO) {
		return new CustomerDB(
				customerDTO.getCreditID(),
				customerDTO.getFirstName(),
				customerDTO.getSecondName(),
				customerDTO.getPesel());
	}

	public CustomerDTO mapToCustomerDTO(final CustomerDB customerDB) {
		return new CustomerDTO(
				customerDB.getId(),
				customerDB.getFirstName(),
				customerDB.getSecondName(),
				customerDB.getPesel());
	}

	public CreditDB mapToCreditDB(final CreditDTO creditDTO) {
		return new CreditDB(
				creditDTO.getCreditID(),
				creditDTO.getCreditName());
	}

	public List<CustomerDTO> mapToCustomerDTOList(final List<CustomerDB> customerDBList) {
		return customerDBList.stream()
				.map(c -> new CustomerDTO(c.getId(), c.getFirstName(), c.getSecondName(), c.getPesel()))
				.collect(Collectors.toList());
	}

	public List<CreditDTO> mapToCreditDTOList(final List<CreditDB> creditDBList) {
		return creditDBList.stream()
				.map(c -> new CreditDTO(c.getId(), c.getCreditName()))
				.collect(Collectors.toList());
	}

	public List<ProductDTO> mapToProductDTOList(final List<ProductDB> productDBList) {
		return productDBList.stream()
				.map(p -> new ProductDTO(p.getId(), p.getProductName(), p.getValue()))
				.collect(Collectors.toList());
	}
}
