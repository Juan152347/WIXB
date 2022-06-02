package com.wixteam.barbershop.Products.Product.Application.Create;

import com.wixteam.barbershop.Products.Product.Domain.Ports.ProductRepository;
import com.wixteam.barbershop.Products.Product.Domain.Product;
import com.wixteam.barbershop.Products.Product.Domain.ValueObjects.*;

public class ProductCreator {
    private ProductRepository repository;
    public ProductCreator(ProductRepository repository){
        this.repository = repository;
    }

    public void execute(String productId, String description, double price, int rating, int quantity){
        Product product = Product.create(
                new ProductId(productId),
                new ProductDescription(description),
                new ProductPrice(price),
                new ProductQuantity(quantity),
                new ProductRating(rating)
        );
        repository.save(product);
    }
}
