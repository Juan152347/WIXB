package com.wixteam.barbershop.Products.Order.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderValue;
import com.wixteam.barbershop.Shared.Domain.Aggregate.DoubleValueObject;

public class OrderValue extends DoubleValueObject {
    public OrderValue() {
    }

    public OrderValue(double value) {
        validate(value);
        this.value = value;
    }
    public void validate(double value){
        notNegative(value);
    }

    public void notNegative( double value){
        if(value<0){
            throw new InvalidOrderValue("El valor no puede ser negativo");
        }
    }
}
