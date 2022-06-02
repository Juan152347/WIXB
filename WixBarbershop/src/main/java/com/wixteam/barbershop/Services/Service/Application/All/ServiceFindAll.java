package com.wixteam.barbershop.Services.Service.Application.All;

import com.wixteam.barbershop.Services.Service.Domain.Ports.ServiceRepository;
import com.wixteam.barbershop.Services.Service.Domain.Service;

import java.util.List;

public class ServiceFindAll {
    private ServiceRepository repository;
    public ServiceFindAll(ServiceRepository repository){this.repository=repository;}
    public List<Service> execute(){return repository.all();}
}
