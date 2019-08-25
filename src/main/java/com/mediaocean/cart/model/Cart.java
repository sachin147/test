package com.mediaocean.cart.model;

import java.util.List;

import com.mediaocean.product.model.Product;

public class Cart {

	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
