package com.wixteam.barbershop.Products.Order.Domain.Exceptions;

public class InvalidOrderValue extends RuntimeException{
    public InvalidOrderValue(String message) {
        super(message);
    }
}
