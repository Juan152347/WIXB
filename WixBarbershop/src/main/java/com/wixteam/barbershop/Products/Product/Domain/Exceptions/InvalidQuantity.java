package com.wixteam.barbershop.Products.Product.Domain.Exceptions;

public class InvalidQuantity extends RuntimeException{
    public InvalidQuantity(String message) {
        super(message);
    }
}
