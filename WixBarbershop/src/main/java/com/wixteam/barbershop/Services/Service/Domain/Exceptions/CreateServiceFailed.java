package com.wixteam.barbershop.Services.Service.Domain.Exceptions;

public class CreateServiceFailed extends RuntimeException{
    public CreateServiceFailed(String message) {
        super(message);
    }
}
