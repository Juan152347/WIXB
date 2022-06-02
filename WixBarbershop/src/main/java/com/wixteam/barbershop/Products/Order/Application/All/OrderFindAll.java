package com.wixteam.barbershop.Products.Order.Application.All;

import com.wixteam.barbershop.Products.Order.Domain.Order;
import com.wixteam.barbershop.Products.Order.Domain.ports.OrderRepostory;


import java.util.List;

public class OrderFindAll {
    private OrderRepostory repository;

    public OrderFindAll(OrderRepostory repository) {
        this.repository = repository;
    }

    public List<Order> execute() {
        return repository.all();
    }
}