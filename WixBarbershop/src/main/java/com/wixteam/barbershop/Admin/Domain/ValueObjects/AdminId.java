package com.wixteam.barbershop.Admin.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class AdminId extends CustomUUID {
    public  AdminId(){}
    public AdminId(String value) {
        super(value);
    }
}
