package com.wixteam.barbershop.Products.Order.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class OrderId extends CustomUUID {
    public OrderId() {
    }

    public OrderId(String value) {
        super(value);
    }
}
