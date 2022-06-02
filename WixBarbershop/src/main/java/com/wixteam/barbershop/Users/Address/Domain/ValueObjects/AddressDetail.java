package com.wixteam.barbershop.Users.Address.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class AddressDetail extends StringValueObject {
    public AddressDetail() {
    }

    public AddressDetail(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){

    }
}
