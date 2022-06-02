package com.wixteam.barbershop.Products.Order.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderDate;
import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class OrderDate extends StringValueObject {
    public OrderDate() {
    }

    public OrderDate(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){
        separate(value);
        lengthValue(value);
    }
    public void separate(String value){
        if(!value.contains("/") && !value.contains("-")){
            throw new InvalidOrderDate("la fecha tiene que estar separada por / o -");
        }
    }
    public void lengthValue(String value){
        if(value.length()!=10 ){
            throw new InvalidOrderDate("Formato de fecha incorrecta tiene que ser dd/mm/aaaa o dd-mm-aaaa ");
        }
    }
}
