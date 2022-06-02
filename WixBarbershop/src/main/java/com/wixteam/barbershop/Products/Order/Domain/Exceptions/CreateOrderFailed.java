package com.wixteam.barbershop.Products.Order.Domain.Exceptions;

public class CreateOrderFailed extends RuntimeException{
    public CreateOrderFailed(String message) {
        super(message);
    }
}
