package com.wixteam.barbershop.Products.Product.Domain.Exceptions;

public class CreateProductFailed extends RuntimeException{
    public CreateProductFailed(String message) {
        super(message);
    }
}
