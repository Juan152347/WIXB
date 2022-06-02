package com.wixteam.barbershop.Products.Product.Domain.Exceptions;

public class InvalidProductPrice extends RuntimeException{
    public InvalidProductPrice(String message) {
        super(message);
    }
}
