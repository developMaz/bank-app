package com.bank.creditComponent.domain;

import com.bank.customerComponent.domain.CustomerDTO;
import com.bank.productComponent.domain.ProductDTO;

public class CreditInfo {

	private CustomerDTO customerDTO;
	private ProductDTO productDTO;
	private CreditDTO creditDTO;


	public CreditInfo(CreditDTO creditDTO) {
		this.creditDTO = creditDTO;
	}

	public CreditInfo(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public CreditInfo(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public CreditInfo(){
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public CreditDTO getCreditDTO() {
		return creditDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public void setCreditDTO(CreditDTO creditDTO) {
		this.creditDTO = creditDTO;
	}
}
