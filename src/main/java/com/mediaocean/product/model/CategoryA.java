package com.mediaocean.product.model;

public class CategoryA implements Category {

	private static double TAX_RATE = 0.10;
	
	public double getTaxRate() {
		return TAX_RATE;
	}

	@Override
	public double getCost(double amount) {
		return amount + amount * getTaxRate();
	}
}
