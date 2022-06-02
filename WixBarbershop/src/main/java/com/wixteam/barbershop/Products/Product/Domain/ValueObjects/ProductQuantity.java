package com.wixteam.barbershop.Products.Product.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidQuantity;
import com.wixteam.barbershop.Shared.Domain.Aggregate.IntegerValueObject;

public class ProductQuantity extends IntegerValueObject {
    public ProductQuantity(){}
    public ProductQuantity(int value) {
        validate(value);
        this.value=value;
    }
    public void validate(int value){
        notVoid(value);
    }
    public void notVoid(int value){
        if(value<=0){
            throw new InvalidQuantity("La cantidad tiene que ser superior a 1");
        }
    }
}
