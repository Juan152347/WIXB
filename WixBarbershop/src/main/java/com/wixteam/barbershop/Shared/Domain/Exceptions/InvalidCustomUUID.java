package com.wixteam.barbershop.Shared.Domain.Exceptions;

public class InvalidCustomUUID extends RuntimeException{
    public InvalidCustomUUID(String message) {
        super(message);
    }
}
