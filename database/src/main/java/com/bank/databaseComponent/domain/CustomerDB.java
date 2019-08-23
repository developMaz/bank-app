package com.bank.databaseComponent.domain;

import javax.persistence.*;

@Entity(name = "CustomerDB")
public class CustomerDB {

	@Id
	@Column(name = "creditId")
	private int id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "secondName")
	private String secondName;

	@Column(name = "pesel", length=11)
	private String pesel;

	public CustomerDB(int id, String firstName, String secondName, String pesel) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.pesel = pesel;
	}

	public CustomerDB(){
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getPesel() {
		return pesel;
	}
}
