package com.bank.productComponent.service;

import com.bank.creditComponent.domain.CreditItem;
import com.bank.databaseComponent.Exceptions.ProductNotFoundException;
import com.bank.databaseComponent.controller.DatabaseController;
import com.bank.productComponent.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	DatabaseController databaseController;

	public void createProduct(ProductDTO productDTO, int creditID){
		productDTO.setCreditID(creditID);
		databaseController.createProduct(productDTO);
	}

	public List<ProductDTO> getAllProducts() {
		return databaseController.getAllProducts();
	}

	public List<CreditItem> getProducts(List<CreditItem> creditItemList) throws Exception {
		ProductDTO product;

		for (CreditItem credit : creditItemList) {
			try {
				product = databaseController.getProductByCreditID(credit.getCreditNumber());
				credit.getCreditInfo().setProductDTO(product);
			} catch (Exception e) {
				throw new ProductNotFoundException();
			}
		}
		return creditItemList;
	}
}
