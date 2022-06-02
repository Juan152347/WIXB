package com.wixteam.barbershop.Products.Order.Application.All;

import com.wixteam.barbershop.Products.Order.Domain.Order;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllOrders {
    private List<Order> orders;

    public AllOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<HashMap<String,Object>> response (){
        return orders.stream().map(order -> order.data()).collect(Collectors.toList());
    }
}
