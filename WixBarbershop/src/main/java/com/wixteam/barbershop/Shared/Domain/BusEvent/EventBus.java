package com.wixteam.barbershop.Shared.Domain.BusEvent;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
