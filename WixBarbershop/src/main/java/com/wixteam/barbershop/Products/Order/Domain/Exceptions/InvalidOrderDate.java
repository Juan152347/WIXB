package com.wixteam.barbershop.Products.Order.Domain.Exceptions;

public class InvalidOrderDate extends RuntimeException{
    public InvalidOrderDate(String message) {
        super(message);
    }
}
