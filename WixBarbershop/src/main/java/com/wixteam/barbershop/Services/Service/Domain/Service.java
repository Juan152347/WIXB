package com.wixteam.barbershop.Services.Service.Domain;

import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceDetails;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServiceId;
import com.wixteam.barbershop.Services.Service.Domain.ValueObjects.ServicePrice;

import java.util.HashMap;

public class Service {
    private ServiceId serviceId;
    private ServicePrice servicePrice;
    private ServiceDetails serviceDetails;

    public Service(){}

    public Service(ServiceId serviceId, ServicePrice servicePrice, ServiceDetails serviceDetails) {
        this.serviceId = serviceId;
        this.servicePrice = servicePrice;
        this.serviceDetails = serviceDetails;
    }

    public static Service create(){
        return null;
    }
    public HashMap<String,Object> data(){
        HashMap<String,Object> data = new HashMap<>(){
            {
                put("id",serviceId.value());
                put("price",servicePrice.value());
                put("deltails",serviceDetails.value());
            }

        };
        return data;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceId serviceId) {
        this.serviceId = serviceId;
    }

    public ServicePrice getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(ServicePrice servicePrice) {
        this.servicePrice = servicePrice;
    }

    public ServiceDetails getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(ServiceDetails serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
