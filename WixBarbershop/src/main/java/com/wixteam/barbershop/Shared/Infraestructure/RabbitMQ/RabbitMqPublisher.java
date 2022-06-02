package com.wixteam.barbershop.Shared.Infraestructure.RabbitMQ;

import com.wixteam.barbershop.Shared.Domain.BusEvent.DomainEvent;
import com.wixteam.barbershop.Shared.Infraestructure.RabbitMQ.Serializable.DomainEventJsonSerializable;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.nio.charset.StandardCharsets;

public class RabbitMqPublisher {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(DomainEvent domainEvent, String exchangeName){
        String serializedDomainEvent = DomainEventJsonSerializable.serializable(domainEvent);
        Message message = new Message(
                serializedDomainEvent.getBytes(),
                MessagePropertiesBuilder.newInstance()
                        .setContentEncoding("utf-8")
                        .setContentType("application/json").build()
        );
        rabbitTemplate.send(exchangeName,domainEvent.eventName(),message);
    }
}
