package com.bank.productComponent.controller;

import com.bank.creditComponent.domain.CreditItem;
import com.bank.productComponent.domain.ProductDTO;
import com.bank.productComponent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	public void createProduct(ProductDTO productDTO, int newCreditNumber) {
		productService.createProduct(productDTO, newCreditNumber);
	}

	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	public List<CreditItem> getProducts(List<CreditItem> creditItemList) throws Exception {
		return productService.getProducts(creditItemList);
	}

}
