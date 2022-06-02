package com.wixteam.barbershop.Users.User.Domain.Exceptions;

public class InvalidName extends RuntimeException{
    public InvalidName(String message) {
        super(message);
    }
}
