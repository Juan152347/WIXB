package com.wixteam.barbershop.Services.Date.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;

public class DateDate extends StringValueObject {
    public DateDate(String value) {
        this.value=value;
    }
    public void validate(){
    }

    public DateDate() {
    }
}
