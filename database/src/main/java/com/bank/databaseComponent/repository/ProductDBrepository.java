package com.bank.databaseComponent.repository;

import com.bank.databaseComponent.domain.ProductDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDBrepository extends CrudRepository<ProductDB, Integer> {

	@Override
	List<ProductDB> findAll();

	@Override
	ProductDB save(ProductDB product);

	Optional<ProductDB> getProductById(int id);

	@Override
	void delete(ProductDB product);
}
