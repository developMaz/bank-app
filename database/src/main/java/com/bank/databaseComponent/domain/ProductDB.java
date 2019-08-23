package com.bank.databaseComponent.domain;

import javax.persistence.*;

@Entity(name = "ProductDB")
public class ProductDB {

	@Id
	@Column(name = "creditId")
	private int id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productValue")
	private int value;

	public ProductDB(int id, String productName, int value) {
		this.id = id;
		this.productName = productName;
		this.value = value;
	}

	public ProductDB() {
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public int getValue() {
		return value;
	}
}
