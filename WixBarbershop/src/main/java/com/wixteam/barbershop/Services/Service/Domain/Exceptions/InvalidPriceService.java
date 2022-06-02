package com.wixteam.barbershop.Services.Service.Domain.Exceptions;

public class InvalidPriceService extends RuntimeException{
    public InvalidPriceService(String message) {
        super(message);
    }
}
