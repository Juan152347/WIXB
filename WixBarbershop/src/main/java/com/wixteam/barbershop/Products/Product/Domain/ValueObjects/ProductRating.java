package com.wixteam.barbershop.Products.Product.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidRankingProduct;
import com.wixteam.barbershop.Services.Service.Domain.Exceptions.InvalidPriceService;
import com.wixteam.barbershop.Shared.Domain.Aggregate.IntegerValueObject;

public class ProductRating extends IntegerValueObject {
    public ProductRating(){}
    public ProductRating(int value) {
        validate(value);
        this.value=value;
    }
    public void validate(int value){
        allowRange(value);
    }
    public void allowRange(int value){
        if (value<0||value>5){
            throw new InvalidRankingProduct("Calificacion fuera del rango");
        }
    }
}
