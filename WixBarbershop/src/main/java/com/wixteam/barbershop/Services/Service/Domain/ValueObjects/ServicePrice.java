package com.wixteam.barbershop.Services.Service.Domain.ValueObjects;

import com.wixteam.barbershop.Services.Service.Domain.Exceptions.InvalidPriceService;
import com.wixteam.barbershop.Shared.Domain.Aggregate.DoubleValueObject;

public class ServicePrice extends DoubleValueObject {
    public ServicePrice(){}

    public ServicePrice(double value) {
        validate(value);
        this.value = value;
    }
    public void validate(double value){
        notNegative(value);
    }
    public void notNegative(double value){
        if(value<0){
            throw new InvalidPriceService("El precio no puede ser negtivo");
        }
    }
}
