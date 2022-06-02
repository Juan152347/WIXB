package com.wixteam.barbershop.Services.Service.Application.Create;

import com.wixteam.barbershop.Services.Service.Domain.Ports.ServiceRepository;
import com.wixteam.barbershop.Services.Service.Domain.Service;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceDetails;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceId;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServicePrice;

public class ServiceCreator {
    private ServiceRepository repository;

    public ServiceCreator(ServiceRepository repository){this.repository=repository;}
    public void execute(String serviceid, double servicePrice, String serviceDetails){
        Service service = new Service(new ServiceId(serviceid), new ServicePrice(servicePrice), new ServiceDetails(serviceDetails));
        repository.save(service);
    }
}
