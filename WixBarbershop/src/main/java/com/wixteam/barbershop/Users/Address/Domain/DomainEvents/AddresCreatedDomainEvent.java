package com.wixteam.barbershop.Users.Address.Domain.DomainEvents;

import com.wixteam.barbershop.Shared.Domain.BusEvent.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class AddresCreatedDomainEvent extends DomainEvent {

    private String city;
    private String detail;
    private String info;

    public AddresCreatedDomainEvent() {
        super(null);
    }

    public AddresCreatedDomainEvent(String aggregateId, String city, String detail, String info) {
        super(aggregateId);
        this.city = city;
        this.detail = detail;
        this.info = info;
    }

    public AddresCreatedDomainEvent(String aggregateId, String eventId, String acorredOn, String city, String detail, String info) {
        super(aggregateId, eventId, acorredOn);
        this.city = city;
        this.detail = detail;
        this.info = info;
    }

    public String getCity() {
        return city;
    }

    public String getDetail() {
        return detail;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String eventName() {
        return "add.barbershop";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>() {{
            put("city",city);
            put("detail",detail);
            put("info",info);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String acorredOn) {
        return new AddresCreatedDomainEvent(aggregateId,eventId,acorredOn,(String) body.get("city"),(String)body.get("detail"),(String)body.get("info"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddresCreatedDomainEvent that = (AddresCreatedDomainEvent) o;
        return Objects.equals(city, that.city) && Objects.equals(detail, that.detail) && Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, detail, info);
    }
}
