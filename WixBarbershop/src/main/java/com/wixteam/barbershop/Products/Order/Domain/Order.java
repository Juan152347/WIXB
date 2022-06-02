package com.wixteam.barbershop.Products.Order.Domain;

import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderDate;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderId;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderStatus;
import com.wixteam.barbershop.Products.Order.Domain.ValueObjects.OrderValue;
import com.wixteam.barbershop.Products.Product.Domain.Product;

import java.util.HashMap;

public class Order {
    private OrderId orderId;
    private OrderValue orderValue;
    private OrderStatus orderStatus;
    private OrderDate orderDate;
    private Product product;

    public  Order(){

    }
    public Order(OrderId orderId, OrderValue orderValue, OrderStatus orderStatus, OrderDate orderDate, Product product) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.product = product;
    }


    public static Order create(OrderId orderId, OrderValue orderValue, OrderStatus orderStatus, OrderDate orderDate, Product product) {
        Order order = new Order(orderId, orderValue, orderStatus, orderDate, product);
        return order;
    }

    public Order(OrderId orderId, OrderStatus orderStatus, OrderDate orderDate) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Order(OrderStatus orderStatus, OrderDate orderDate) {
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderValue getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(OrderValue orderValue) {
        this.orderValue = orderValue;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(OrderDate orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public static Order create(){
        return null;
    }

    public HashMap<String,Object> data(){
        HashMap<String,Object> data = new HashMap<>(){
            {
                put("Id:",orderId.value());
                put("status",orderStatus.value());
                put("date",orderDate.value());
            }

        };
        return data;
    }
}
