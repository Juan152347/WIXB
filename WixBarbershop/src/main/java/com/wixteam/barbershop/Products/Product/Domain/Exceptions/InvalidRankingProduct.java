package com.wixteam.barbershop.Products.Product.Domain.Exceptions;

public class InvalidRankingProduct extends RuntimeException{
    public InvalidRankingProduct(String message) {
        super(message);
    }
}
