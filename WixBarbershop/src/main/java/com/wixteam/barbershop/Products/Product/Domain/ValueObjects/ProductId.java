package com.wixteam.barbershop.Products.Product.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.CustomUUID;

public class ProductId extends CustomUUID {
    public ProductId(String value) {
        super(value);
    }
}
