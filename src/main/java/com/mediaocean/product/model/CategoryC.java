package com.mediaocean.product.model;

public class CategoryC implements Category {

	private static double TAX_RATE = 0.0;

	public double getCost(double amount) {
		return amount;
	}

	public double getTaxRate() { return TAX_RATE; }
}
