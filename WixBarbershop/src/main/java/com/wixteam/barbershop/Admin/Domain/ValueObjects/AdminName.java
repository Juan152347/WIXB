package com.wixteam.barbershop.Admin.Domain.ValueObjects;

import com.wixteam.barbershop.Admin.Domain.Exceptions.InvalidNameAdmin;
import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;

public class AdminName extends StringValueObject {
    public AdminName(String value) {
        validate(value);
        this.value = value;
    }
    public AdminName(){}
    public void validate(String value){
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
           throw new InvalidNameAdmin(" Caracteres no validos ");
        }
    }
}
