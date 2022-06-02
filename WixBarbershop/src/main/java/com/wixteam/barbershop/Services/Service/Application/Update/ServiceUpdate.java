package com.wixteam.barbershop.Services.Service.Application.Update;

import com.wixteam.barbershop.Services.Service.Domain.Ports.ServiceRepository;
import com.wixteam.barbershop.Services.Service.Domain.Service;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceDetails;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceId;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServicePrice;

public class ServiceUpdate {
    private ServiceRepository repository;

    public ServiceUpdate(ServiceRepository repository){this.repository=repository;}

    public void execute(String serviceid, double servicePrice, String serviceDetails){
        Service service = new Service(new ServiceId(serviceid), new ServicePrice(servicePrice), new ServiceDetails(serviceDetails));
        repository.update(service,serviceid);
    }
}
