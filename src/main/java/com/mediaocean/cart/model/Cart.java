package com.mediaocean.cart.model;

import java.util.List;

import com.mediaocean.product.model.Product;

public class Cart {
	
	private String customerName;
	private List<Product> products;
	//private BillGenerator billGenerator = new BillGenerator();  ------>  delegate to utility class
	//private TaxCalculator taxCalculator = new TaxCalculator();  ------>  delegate to utility class
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getBill() {
		//return billgenerator.getBill(products);

		StringBuilder billStatement = new StringBuilder();
		billStatement.append("--- id --- | ---name---| ---price--- | ---tax---");
		billStatement.append("\n");
		for(Product product : products) {
			billStatement.append("---"+product.getProductId()+"--- |");
			billStatement.append("---"+product.getName()+"--- |");
			billStatement.append("---"+product.getPrice()+"--- |");
			billStatement.append("---"+product.getCategory().getTaxRate()+"--- |");
			billStatement.append("\n");
		}
		double totalSalesTax = getTotalSalesTax();
		double totalCost =  getTotalCost();

		billStatement.append("--- totalsalestax --- | ---totalcost---");
		billStatement.append("\n");
		billStatement.append("---"+totalSalesTax+" --- | ---"+totalCost+"---");
		return billStatement.toString();
	}

	public double getTotalSalesTax() {
		double totalSalesTaxAmount = 0.0;
		for(Product product : products) {
			//totalSalesTaxAmount += taxCalculator.calculateTax(product)
			totalSalesTaxAmount += product.getPrice() * product.getCategory().getTaxRate();
		}
		return  totalSalesTaxAmount;
	}

	public double getTotalCost() {
		double totalAmount = 0.0;
		for(Product product : products) {
			totalAmount += product.getCost();
		}
		return totalAmount;
	}

}
