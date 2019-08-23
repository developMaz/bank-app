package com.bank.creditComponent.service;

import com.bank.creditComponent.domain.CreditDTO;
import com.bank.creditComponent.domain.CreditInfo;
import com.bank.databaseComponent.controller.DatabaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CreditService {

	@Autowired
	DatabaseController databaseController;

	Random random = new Random();
	List<CreditInfo> list = new ArrayList<>();

	public int generateCreditNumber() {
		int creditNumber = random.nextInt(8999) + 1000;
		return creditNumber;
	}

	public void saveCredit(CreditDTO creditDTO, int creditNumber) {
		creditDTO.setCreditID(creditNumber);
		databaseController.saveCredit(creditDTO);
	}

	public List<CreditDTO> getAllCredits() {

		return databaseController.getAllCredits();

	}



}

// TODO checking if save ok
//	private boolean isAllCreditInfoSave = false;
//


//
//	public boolean checkCredit(int creditID){
//
//		return  isAllCreditInfoSave;
//	}

