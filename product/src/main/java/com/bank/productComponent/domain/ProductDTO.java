package com.bank.productComponent.domain;

public class ProductDTO {

	private int creditID;
	private String productName;
	private int productValue;

	public int getCreditID() {
		return creditID;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductValue() {
		return productValue;
	}

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductValue(int productValue) {
		this.productValue = productValue;
	}

	public ProductDTO(int creditID, String productName, int productValue) {
		this.creditID = creditID;
		this.productName = productName;
		this.productValue = productValue;
	}

	public ProductDTO(String productName, int productValue) {
		this.productName = productName;
		this.productValue = productValue;
	}

	@Override
	public String toString() {
		return "ProductDTO{" +
				"productName='" + productName + '\'' +
				", productValue=" + productValue +
				'}';
	}
}
