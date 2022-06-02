package com.wixteam.barbershop.Admin.Domain.Exceptions;

public class CreateAdminFailed extends RuntimeException{
    public CreateAdminFailed(String message) {
        super(message);
    }
}
