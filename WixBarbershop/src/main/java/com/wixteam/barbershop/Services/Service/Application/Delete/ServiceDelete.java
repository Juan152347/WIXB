package com.wixteam.barbershop.Services.Service.Application.Delete;

import com.wixteam.barbershop.Services.Service.Domain.Ports.ServiceRepository;
import com.wixteam.barbershop.Users.User.Domain.Ports.UserRepository;

public class ServiceDelete {
    private ServiceRepository repository;

    public ServiceDelete(ServiceRepository repository){this.repository=repository;}
    public void execute(String idService){repository.delete(idService);}
}
