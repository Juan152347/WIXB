package com.wixteam.barbershop.Users.Address.Domain.Ports;

import com.wixteam.barbershop.Users.Address.Domain.Address;

import java.util.List;

public interface AddressRepository {

    public void  save(Address address);
    public List<Address> all();
}
