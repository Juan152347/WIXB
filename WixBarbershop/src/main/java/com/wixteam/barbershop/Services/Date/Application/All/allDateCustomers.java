package com.wixteam.barbershop.Services.Date.Application.All;

import com.wixteam.barbershop.Services.Date.Domain.Date;
import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;


import java.util.List;

public class allDateCustomers {
    private DateRepository repository;
    public allDateCustomers(DateRepository repository) {
        this.repository = repository;
    }
    public List<Date> execute(String idUser){
        return  repository.allDateTypeUser(idUser, "Customer");
    }
}
