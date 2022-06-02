package com.wixteam.barbershop.Products.Order.Domain.ports;

import com.wixteam.barbershop.Products.Order.Domain.Order;

import java.util.List;

public interface OrderRepostory {
    public void save(Order order);
    public List<Order> all();
    public void delete(String idOrder);
    public void Update(Order order, String idOrder);
}
