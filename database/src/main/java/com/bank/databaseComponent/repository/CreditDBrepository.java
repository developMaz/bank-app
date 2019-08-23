package com.bank.databaseComponent.repository;

import com.bank.databaseComponent.domain.CreditDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditDBrepository extends CrudRepository<CreditDB, Integer> {

	@Override
	List<CreditDB> findAll();

	@Override
	CreditDB save(CreditDB creditDB);

	Optional<CreditDB> getCreditById(int id);

	@Override
	void delete(CreditDB creditDB);
}
