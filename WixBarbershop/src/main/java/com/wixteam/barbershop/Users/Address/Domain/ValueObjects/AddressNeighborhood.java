package com.wixteam.barbershop.Users.Address.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class AddressNeighborhood extends StringValueObject {
    public AddressNeighborhood() {
    }

    public AddressNeighborhood(String value) {
        validate(value);
        this.value = value;

    }
    public void  validate(String value){

    }
}
