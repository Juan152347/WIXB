package com.wixteam.barbershop.Users.User.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class UserType extends StringValueObject {


    public UserType(String value) {
        validate(value);
        this.value = value;
    }

    public UserType() {
    }

    private void validate(String value){

    }
}
