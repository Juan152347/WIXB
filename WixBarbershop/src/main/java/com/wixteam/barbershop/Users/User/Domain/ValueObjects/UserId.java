package com.wixteam.barbershop.Users.User.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class UserId extends CustomUUID {
    private UserId() {
    }
    public UserId(String value) {
        super(value);
    }
}
