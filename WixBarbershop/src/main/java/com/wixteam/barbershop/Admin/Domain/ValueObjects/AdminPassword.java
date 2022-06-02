package com.wixteam.barbershop.Admin.Domain.ValueObjects;

import com.wixteam.barbershop.Admin.Domain.Exceptions.InvalidPasswordAdmin;
import com.wixteam.barbershop.Shared.Domain.Aggregate.StringValueObject;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;

public class AdminPassword extends StringValueObject {
    public AdminPassword(String value) {
        validate(value);
        this.value=value;
    }
    public AdminPassword(){}
    public void validate(String value){
        lengthValue(value);
        numbers(value);
    }

    public void lengthValue(String value){
        if(value.length()<8 ){
            throw new LengthInvalid("Longitud invalida");
        }
    }
    public void numbers(String value){
        if(!value.contains("0")&&!value.contains("1")&&!value.contains("2")&&!value.contains("3")&&
                !value.contains("4")&&!value.contains("5")&&!value.contains("6")&&!value.contains("7")&&
                !value.contains("8")&&!value.contains("9")){
            throw new InvalidPasswordAdmin("la contraseña requiere minimo un numero");
        }
    }
    public void characters(String value){
        if(!value.contains("#")||!value.contains("$")||!value.contains("%")||!value.contains("&")||
                !value.contains("!")||!value.contains("*")||!value.contains("+")||!value.contains("@")||
                !value.contains("¡")||!value.contains("¿")){
            throw new InvalidPasswordAdmin("la contraseña requiere minimo un caracter espacial");
        }
    }

}
