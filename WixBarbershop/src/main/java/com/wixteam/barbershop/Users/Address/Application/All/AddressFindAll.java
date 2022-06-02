package com.wixteam.barbershop.Users.Address.Application.All;

import com.wixteam.barbershop.Users.Address.Domain.Address;
import com.wixteam.barbershop.Users.Address.Domain.Ports.AddressRepository;
import com.wixteam.barbershop.Users.User.Domain.User;

import java.util.List;

public class AddressFindAll {
    private AddressRepository repository;

    public AddressFindAll(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> execute() {
        return repository.all();
    }
}
