package com.wixteam.barbershop.Services.Service.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class ServiceDetails extends StringValueObject {

    public ServiceDetails(){}

    public ServiceDetails(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){

    }
}
