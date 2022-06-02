package com.wixteam.barbershop.Services.Date.Domain.Exceptions;

public class CreateDateFailed extends RuntimeException{
    public CreateDateFailed(String message) {
        super(message);
    }
}
