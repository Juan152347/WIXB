package com.wixteam.barbershop.Users.Address.Application.All;

import com.wixteam.barbershop.Users.Address.Domain.Address;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllAddress {
    private List<Address> address;
    public  AllAddress(List<Address> address){this.address = address;}

    public List<HashMap<String,Object>> response() {
        List<HashMap<String, Object>> response = address.stream().map(address -> address.data()).collect(Collectors.toList());
        return response;
    }
}
