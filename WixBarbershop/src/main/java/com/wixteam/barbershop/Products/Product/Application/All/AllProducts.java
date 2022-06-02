package com.wixteam.barbershop.Products.Product.Application.All;

import com.wixteam.barbershop.Products.Product.Domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllProducts {
    private List<Product> products;
    public AllProducts(List<Product> products){ this.products = products; }
    public List<HashMap<String,Object>> execute(){
        return products.stream().map(prod -> prod.data()).collect(Collectors.toList());
    }
}
