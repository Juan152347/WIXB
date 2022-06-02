package com.wixteam.barbershop.Users.User.Domain.Exceptions;

public class InvalidPhone extends RuntimeException{
    public InvalidPhone(String message) {
        super(message);
    }
}
