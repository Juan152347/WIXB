package com.wixteam.barbershop.Products.Order.Domain.ValueObjects;

import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderStatus;
import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class OrderStatus extends StringValueObject {

    public OrderStatus() {
    }

    public OrderStatus(String value) {
        validate(value);
        this.value=value;
    }
    public void validate(String value){
        allowedStatus(value);
    }
    public  void allowedStatus(String value){
        if(!value.equals("ACEPTADO")&&!value.equals("ENTREGADO")&&value.equals("EN CAMINO")&&!value.equals("CANCELADO")&&!value.equals("PAGADO")){
            throw new InvalidOrderStatus("Status no permitido");
        }
    }
}
