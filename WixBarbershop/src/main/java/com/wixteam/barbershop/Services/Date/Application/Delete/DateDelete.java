package com.wixteam.barbershop.Services.Date.Application.Delete;

import com.wixteam.barbershop.Services.Date.Domain.Port.DateRepository;

public class DateDelete {
    private DateRepository repository;
    public DateDelete(DateRepository repository) {
        this.repository = repository;
    }
    public void execute(String idDate){ repository.delete(idDate);}
}
