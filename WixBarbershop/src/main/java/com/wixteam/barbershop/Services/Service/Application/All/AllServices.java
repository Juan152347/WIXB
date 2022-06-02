package com.wixteam.barbershop.Services.Service.Application.All;

import com.wixteam.barbershop.Services.Service.Domain.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllServices {
    private List<Service> services;

    public AllServices(List<Service> services){this.services=services;}

    public List<HashMap<String,Object>> response(){
        List<HashMap<String,Object>> response = services.stream().map(service -> service.data()).collect(Collectors.toList());
        return response;
    }
}
