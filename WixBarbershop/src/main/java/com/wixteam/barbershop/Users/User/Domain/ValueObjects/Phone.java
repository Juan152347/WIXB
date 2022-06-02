package com.wixteam.barbershop.Users.User.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.InvalidPassword;

import java.util.HashMap;

public class Phone extends StringValueObject {
    public Phone() {
    }

    public Phone(String value) {
        validate(value);
        this.value = value;
    }
    private void validate(String value){
        length(value);
    }
    public void length( String value){
        if(value.length()<10||value.length()>11){
            throw new InvalidPassword("numero corto");
        }
    }
}
