package com.wixteam.barbershop.Products.Order.Domain.Exceptions;

public class InvalidOrderStatus extends RuntimeException{
    public InvalidOrderStatus(String message) {
        super(message);
    }
}
