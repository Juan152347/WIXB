package com.wixteam.barbershop.Services.Date.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class DateId extends CustomUUID {
    public DateId() {
    }

    public DateId(String value) {
        super(value);
    }
}
