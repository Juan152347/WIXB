package com.wixteam.barbershop.Products.Order.Application.Update;

import com.wixteam.barbershop.Products.Order.Domain.Order;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderDate;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderId;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderStatus;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderValue;
import com.wixteam.barbershop.Products.Order.Domain.ports.OrderRepostory;

public class OrderUpdate {
    private OrderRepostory repostory;

    public OrderUpdate(OrderRepostory repostory) {
        this.repostory = repostory;
    }

    public void execute(String orderid,String orderStatus,String orderdate){
        Order order = new Order(new OrderStatus(orderStatus),new OrderDate(orderdate));
        repostory.Update(order,orderid);
    }
}
