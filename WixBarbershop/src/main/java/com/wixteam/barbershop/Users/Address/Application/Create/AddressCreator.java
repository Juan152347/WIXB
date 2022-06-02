package com.wixteam.barbershop.Users.Address.Application.Create;

import com.wixteam.barbershop.Shared.Domain.BusEvent.EventBus;
import com.wixteam.barbershop.Users.Address.Domain.Address;
import com.wixteam.barbershop.Users.Address.Domain.ValueObjects.*;
import com.wixteam.barbershop.Users.Address.Domain.Ports.AddressRepository;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserId;

public class AddressCreator {
    private AddressRepository repository;
    private final EventBus eventBus;
    public AddressCreator(AddressRepository repository, EventBus eventBus){
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String id, String detail, String city, String additionalInfo , String neighborhood , String userId){
        Address address = new Address(new AddressId(id) , new AddressDetail(detail) , new AddressCity(city) , new AddressAdditionalInfo(additionalInfo), new AddressNeighborhood(neighborhood), new UserId(userId));
        this.repository.save(address);
        this.eventBus.publish(address.pullDomainEvents());
    }
}
