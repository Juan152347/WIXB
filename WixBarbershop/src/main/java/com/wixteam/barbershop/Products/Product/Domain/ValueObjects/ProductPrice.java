package com.wixteam.barbershop.Products.Product.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidProductPrice;
import com.wixteam.barbershop.Shared.Domain.Aggregate.DoubleValueObject;

public class ProductPrice extends DoubleValueObject {
    public ProductPrice(){}
    public ProductPrice(double value) {
        validate(value);
        this.value=value;
    }
    public void validate(double value){

    }
    public void notFree(double value){
        if(value<=0){
            throw new InvalidProductPrice("El precio no puede ser igual o menor a 0");
        }
    }
}
