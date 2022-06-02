package com.wixteam.barbershop.Users.Address.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class AddressAdditionalInfo extends StringValueObject {
    public AddressAdditionalInfo() {
    }

    public AddressAdditionalInfo(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){

    }
}
