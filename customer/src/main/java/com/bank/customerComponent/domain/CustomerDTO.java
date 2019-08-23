package com.bank.customerComponent.domain;

//@Getter
//@AllArgsConstructor
public class CustomerDTO {

	private int creditID;
	private String firstName;
	private String secondName;
	private String pesel;

	public CustomerDTO(String firstName, String secondName, String pesel) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.pesel = pesel;
	}

	public CustomerDTO(int creditID, String firstName, String secondName, String pesel) {
		this.creditID = creditID;
		this.firstName = firstName;
		this.secondName = secondName;
		this.pesel = pesel;
	}


	public int getCreditID() {
		return creditID;
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

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String toString() {
		return "CustomerDTO{" +
				"firstName='" + firstName + '\'' +
				", secondName='" + secondName + '\'' +
				", pesel='" + pesel + '\'' +
				'}';
	}
}
