package com.mediaocean.cart.service;

import com.mediaocean.cart.model.Cart;
import com.mediaocean.product.model.Product;

import java.util.List;

public class CartService {

    String getBill(Cart cart) {
        List<Product> products = cart.getProducts();
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
        double totalSalesTax = getTotalSalesTax(products);
        double totalCost =  getTotalCost(products);

        billStatement.append("--- totalsalestax --- | ---totalcost---");
        billStatement.append("\n");
        billStatement.append("---"+totalSalesTax+" --- | ---"+totalCost+"---");
        return billStatement.toString();
    }

    Double getTotalSalesTax(List<Product> products) {
        Double totalSalesTaxAmount = 0.0d;
        for(Product product : products) {
            totalSalesTaxAmount += getSalesTaxAmount(product);
        }
        return  totalSalesTaxAmount;
    }

    Double getSalesTaxAmount(Product product) {
        return product.getPrice() * product.getCategory().getTaxRate();
    }

     Double getTotalCost(List<Product> products) {
        return products.stream().map(x -> x.getCost()).reduce(0.0, Double::sum);
    }
}
