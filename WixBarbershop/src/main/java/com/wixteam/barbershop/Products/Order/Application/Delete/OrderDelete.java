package com.wixteam.barbershop.Products.Order.Application.Delete;

import com.wixteam.barbershop.Products.Order.Domain.ports.OrderRepostory;

public class OrderDelete {
    private OrderRepostory repostory;

    public OrderDelete(OrderRepostory repostory) {
        this.repostory = repostory;
    }
    public void execute(String idOrder){repostory.delete(idOrder);}
}
