package com.bank.databaseComponent.service;

import com.bank.databaseComponent.domain.CustomerDB;
import com.bank.databaseComponent.repository.CustomerDBrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDBservice {

	@Autowired
	CustomerDBrepository customerDBrepository;

	public List<CustomerDB> getAllCustomers(){
		return customerDBrepository.findAll();
	}

	public CustomerDB createCustomer(final CustomerDB customerDB){
		return customerDBrepository.save(customerDB);
	}

	public Optional<CustomerDB> getCustomerById(int creditID){
		return customerDBrepository.getCustomerById(creditID);
	}

	public void deleteCustomer(CustomerDB customerDB){
		customerDBrepository.delete(customerDB);
	}
}
