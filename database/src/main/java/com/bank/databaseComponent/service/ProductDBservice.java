package com.bank.databaseComponent.service;

import com.bank.databaseComponent.domain.ProductDB;
import com.bank.databaseComponent.repository.ProductDBrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDBservice {

	@Autowired
	ProductDBrepository productDBrepository;

	public List<ProductDB> getAllProducts(){
		return productDBrepository.findAll();
	}

	public ProductDB createProduct(final ProductDB productDB){
		return productDBrepository.save(productDB);
	}

	public Optional<ProductDB> getProductById(int id){
		return productDBrepository.getProductById(id);
	}

	public void deleteProduct(ProductDB productDB){
		productDBrepository.delete(productDB);
	}
}
