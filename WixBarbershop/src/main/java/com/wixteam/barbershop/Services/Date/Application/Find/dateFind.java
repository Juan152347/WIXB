package com.wixteam.barbershop.Services.Date.Application.Find;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;

public class dateFind {
    private DateRepository repository;
    public dateFind(DateRepository repository) {
        this.repository = repository;
    }
    public Date execute(String idDate){
        return repository.find(idDate);
    };
}
