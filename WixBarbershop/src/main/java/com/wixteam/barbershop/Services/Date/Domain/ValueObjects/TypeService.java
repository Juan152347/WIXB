package com.wixteam.barbershop.Services.Date.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class TypeService extends StringValueObject {
    public TypeService() {
    }
    public void validate(){
    }
    public TypeService(String value) {
        this.value=value;
    }
}
