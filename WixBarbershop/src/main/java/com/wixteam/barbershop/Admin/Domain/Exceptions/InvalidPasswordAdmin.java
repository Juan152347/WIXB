package com.wixteam.barbershop.Admin.Domain.Exceptions;

public class InvalidPasswordAdmin extends RuntimeException{
    public InvalidPasswordAdmin(String message) {
        super(message);
    }
}
