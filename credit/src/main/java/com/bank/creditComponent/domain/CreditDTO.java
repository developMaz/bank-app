package com.bank.creditComponent.domain;

public class CreditDTO {

	private int creditID;
	private String creditName;

	public CreditDTO(int creditID, String creditName) {
		this.creditID = creditID;
		this.creditName = creditName;
	}

	public CreditDTO(String creditName) {
		this.creditName = creditName;
	}

	public int getCreditID() {
		return creditID;
	}


	public String getCreditName() {
		return creditName;
	}

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}

	@Override
	public String toString() {
		return "CreditDTO{" +
				"creditName='" + creditName + '\'' +
				'}';
	}
}
