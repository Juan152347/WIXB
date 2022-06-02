package com.wixteam.barbershop.Admin.Domain.Exceptions;

public class InvalidNameAdmin extends RuntimeException{
    public InvalidNameAdmin(String message) {
        super(message);
    }
}
