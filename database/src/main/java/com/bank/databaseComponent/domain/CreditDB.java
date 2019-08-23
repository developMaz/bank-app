package com.bank.databaseComponent.domain;

import javax.persistence.*;

@Entity(name = "CreditDB")
public class CreditDB {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "creditName")
	private String creditName;

	public CreditDB(int id, String creditName) {
		this.id = id;
		this.creditName = creditName;
	}

	public CreditDB(){

	}

	public int getId() {
		return id;
	}

	public String getCreditName() {
		return creditName;
	}
}
