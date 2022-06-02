package com.wixteam.barbershop.Services.Service.Domain.Ports;

import com.wixteam.barbershop.Services.Service.Domain.Service;

import java.util.List;

public interface ServiceRepository {
    public void save(Service service);
    public List<Service> all();
    public void delete(String idService);
    public void update(Service service, String idService);
}
