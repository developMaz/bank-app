package com.bank.customerComponent.service;

import com.bank.creditComponent.domain.CreditItem;
import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.databaseComponent.Exceptions.CustomerNotFoundException;
import com.bank.databaseComponent.controller.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	@Autowired
	DatabaseController databaseController;

	public void createCustomer(CustomerDTO customerDTO, int creditID) {
		customerDTO.setCreditID(creditID);
		databaseController.createCustomer(customerDTO);
	}

	public List<CustomerDTO> getAllCustomers() {
		return databaseController.getAllCustomers();
	}


	public List<CreditItem> getCustomers(List<CreditItem> creditItemList) throws CustomerNotFoundException {
		CustomerDTO customer;

		for (CreditItem credit : creditItemList) {
			try {
				customer = databaseController.getCustomerByCreditID(credit.getCreditNumber());
				credit.getCreditInfo().setCustomerDTO(customer);
			} catch (Exception e) {
				throw new CustomerNotFoundException();
			}
		}
		return creditItemList;
	}

	// For every position from list of credit, find and get customer data, and add to new list.
	// Return list of Customers(by credit list)
//	public List<CustomerDTO> getCustomers(List<CreditDTO> creditDTOList) throws CustomerNotFoundException {
//		List<CustomerDTO> customersList = new ArrayList<>();
//
//		for (CreditDTO credit : creditDTOList) {
//			customersList.add(databaseController.getCustomerByCreditID(credit.getCreditID()));
//		}
//
//		return customersList;
//	}

}
