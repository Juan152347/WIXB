package com.wixteam.barbershop.Users.Address.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class AddressId extends CustomUUID {
    public AddressId() {
    }
    public AddressId(String value) {
        super(value);
    }
}
