package com.wixteam.barbershop.Users.Address.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class AddressCity extends StringValueObject {
    public AddressCity() {
    }

    public AddressCity(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){

    }
}
