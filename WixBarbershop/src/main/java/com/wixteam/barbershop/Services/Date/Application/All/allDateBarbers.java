package com.wixteam.barbershop.Services.Date.Application.All;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;

import java.util.List;


public class allDateBarbers {
    private DateRepository repository;
    public allDateBarbers(DateRepository repository) {
        this.repository = repository;
    }
    public List<Date> execute(String idUser){
        return  repository.allDateTypeUser(idUser, "Barber");
    }
}
