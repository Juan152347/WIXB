package com.wixteam.barbershop.Shared.Infraestructure.RabbitMQ.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wixteam.barbershop.Shared.Domain.BusEvent.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class DomainEventJsonSerializable {

    public static  String serializable(DomainEvent domainEvent){
        HashMap<String, Serializable> attributes = domainEvent.toPrimitive();
        attributes.put("id", domainEvent.getAggregateId());
        HashMap<String,Serializable> message = new HashMap<>();
        message.put("data", new HashMap<String,Serializable>(){{
            put("id",domainEvent.getEventId());
            put("type",domainEvent.eventName());
            put("ocurred_on",domainEvent.getAcorredOn());
            put("attributes",attributes);
        }});
        message.put("meta", new HashMap<String,Serializable>());
        return jsonEncode(message);
    }

    public static String jsonEncode(HashMap<String,Serializable> map){
        try {
            return new ObjectMapper().writeValueAsString(map);
        }catch (Exception e){
            return "";
        }
    }
}
