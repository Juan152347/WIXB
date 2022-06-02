package com.wixteam.barbershop.Services.Date.Application.All;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;

import java.util.List;

public class DateFindAll {
    private DateRepository repository;
    public DateFindAll(DateRepository repository) {
        this.repository = repository;
    }
    public List<Date> execute(){
        return  repository.all();
    }
}
