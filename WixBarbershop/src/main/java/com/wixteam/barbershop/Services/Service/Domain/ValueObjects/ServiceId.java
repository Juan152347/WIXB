package com.wixteam.barbershop.Services.Service.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class ServiceId extends CustomUUID {
    public ServiceId() {
    }
    public ServiceId(String value) {
        super(value);
    }
}
