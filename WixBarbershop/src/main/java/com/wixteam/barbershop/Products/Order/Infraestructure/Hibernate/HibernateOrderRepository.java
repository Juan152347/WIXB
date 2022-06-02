package com.wixteam.barbershop.Products.Order.Infraestructure.Hibernate;

import com.wixteam.barbershop.Products.Order.Domain.Order;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderId;
import com.wixteam.barbershop.Products.Order.Domain.ports.OrderRepostory;
import com.wixteam.barbershop.Shared.Infraestructure.Hibernate.HibernateRespository;
import com.wixteam.barbershop.Users.User.Domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional("transactional-manager")
public class HibernateOrderRepository extends HibernateRespository<Order> implements OrderRepostory {
    protected  HibernateOrderRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }

    @Override
    public void save(Order order) {
        persist(order);
    }

    @Override
    public List<Order> all() {
        return getAll().get();
    }

    @Override
    public void delete(String idOrder) {
        Order order = byId(new OrderId(idOrder)).get();
        deleteEntity(order);
    }

    @Override
    public void Update(Order order, String idOrder) {
        Order ord = byId(new OrderId(idOrder)).get();
        if (order.getOrderStatus().value() != null) {
            ord.setOrderStatus(order.getOrderStatus());
        }
        if (order.getOrderDate().value() != null)
            ord.setOrderDate(order.getOrderDate());
        updateEntity(ord);
    }
}
