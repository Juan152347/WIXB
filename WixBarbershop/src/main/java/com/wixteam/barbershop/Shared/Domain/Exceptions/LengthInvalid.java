package com.wixteam.barbershop.Shared.Domain.Exceptions;

public class LengthInvalid extends RuntimeException{
    public LengthInvalid(String message) {
        super(message);
    }
}
