package com.bank.databaseComponent.service;

import com.bank.databaseComponent.domain.CreditDB;
import com.bank.databaseComponent.repository.CreditDBrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditDBservice {

	@Autowired
	CreditDBrepository creditDBrepository;

	public List<CreditDB> getAllCredits(){
		return creditDBrepository.findAll();
	}

	public CreditDB saveCredit(final CreditDB creditDB){
		return creditDBrepository.save(creditDB);
	}

	public Optional<CreditDB> getCreditById(int id){
		return creditDBrepository.getCreditById(id);
	}

	public void deleteCredit(CreditDB creditDB){
		creditDBrepository.delete(creditDB);
	}
}
