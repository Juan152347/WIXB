package com.wixteam.barbershop.Shared.Domain.BusEvent;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public  abstract class DomainEvent {

    private String aggregateId;
    private String eventId;
    private String acorredOn;

    public  DomainEvent (String aggregateId){
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.acorredOn = this.dateToString(LocalDateTime.now());
    }

    public DomainEvent (String aggregateId , String eventId , String acorredOn){
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.acorredOn = acorredOn;
    }

    protected DomainEvent(){}

    protected String dateToString (LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getAcorredOn() {
        return acorredOn;
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitive();

    public  abstract DomainEvent fromPrimitive (String aggregateId, HashMap<String,Serializable> body,
                                       String eventId, String acorredOn);
}
