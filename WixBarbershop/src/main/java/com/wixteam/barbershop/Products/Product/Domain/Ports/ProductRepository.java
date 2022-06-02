package com.wixteam.barbershop.Products.Product.Domain.Ports;

import com.wixteam.barbershop.Products.Product.Domain.Product;

import java.util.List;

public interface ProductRepository {
    public void save(Product product);
    public List<Product> all();
}
