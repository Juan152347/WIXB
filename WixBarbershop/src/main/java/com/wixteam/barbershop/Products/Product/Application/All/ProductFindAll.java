package com.wixteam.barbershop.Products.Product.Application.All;

import com.wixteam.barbershop.Products.Product.Domain.Ports.ProductRepository;
import com.wixteam.barbershop.Products.Product.Domain.Product;

import java.util.List;

public class ProductFindAll {
    private ProductRepository repository;
    public ProductFindAll(ProductRepository repository){ this.repository = repository; }
    public List<Product> execute(){ return repository.all(); }
}
