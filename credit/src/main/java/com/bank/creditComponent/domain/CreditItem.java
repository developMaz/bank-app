package com.bank.creditComponent.domain;

public class CreditItem {

	private int creditNumber;
	private CreditInfo creditInfo;


	public CreditItem (CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
		this.creditNumber = creditInfo.getCreditDTO().getCreditID();
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public CreditInfo getCreditInfo() {
		return creditInfo;
	}

	@Override
	public String toString() {
		return "CreditItem{" +
				"creditNumber=" + creditNumber +
				'}';
	}
}
