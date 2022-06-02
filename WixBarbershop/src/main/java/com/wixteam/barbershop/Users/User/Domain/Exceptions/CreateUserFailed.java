package com.wixteam.barbershop.Users.User.Domain.Exceptions;

public class CreateUserFailed extends RuntimeException{
    public CreateUserFailed(String message) {
        super(message);
    }
}
