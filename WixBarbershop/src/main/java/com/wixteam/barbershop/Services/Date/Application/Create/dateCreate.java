package com.wixteam.barbershop.Services.Date.Application.Create;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;
import com.wixteam.barbershop.Services.Date.Domain.ValueObjects.DateDate;
import com.wixteam.barbershop.Services.Date.Domain.ValueObjects.DateId;
import com.wixteam.barbershop.Services.Date.Domain.ValueObjects.TypeService;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceId;
import com.wixteam.barbershop.Users.Address.Domain.ValueObjects.AddressId;
import com.wixteam.barbershop.Users.User.Domain.ValueObjects.UserId;

public class dateCreate {
    private DateRepository repository;

    public dateCreate(DateRepository repository) {
        this.repository = repository;
    }
    public void execute(String dateId, String userId, String barberoid, String typeService, String serviceId, String dateDate, String addID){
        Date date = new Date(new DateId(dateId), new UserId(userId), new UserId(barberoid), new TypeService(typeService), new ServiceId(serviceId), new DateDate(dateDate), new AddressId(addID));
        repository.save(date);
    }
}
