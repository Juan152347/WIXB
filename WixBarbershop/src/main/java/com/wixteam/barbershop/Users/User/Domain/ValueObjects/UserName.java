package com.wixteam.barbershop.Users.User.Domain.ValueObjects;

import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.InvalidName;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;

public class UserName extends StringValueObject {


    public UserName(String value) {
        validate(value);
        this.value = value;
    }

    public UserName() {
    }

    private void validate(String value){
        lengthValue(value);
        notAllowedCharacter(value);
    }
    public void lengthValue(String value){
        if(value.length()<2 || value.length()>20){
            throw new LengthInvalid(" Longitud invalida ");
        }
    }
    private void notAllowedCharacter(String value){
        if(value.contains("$") ||value.contains("%")||value.contains("&")||
                value.contains("!")||value.contains("?")||value.contains("¡")||
                value.contains("¿")||value.contains("*")){
            throw new InvalidName(" Caracteres no validos ");
        }
    }
}
