package com.wixteam.barbershop.Products.Product.Infraestructure.Controllers;

import com.wixteam.barbershop.Products.Product.Application.All.AllProducts;
import com.wixteam.barbershop.Products.Product.Application.All.ProductFindAll;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Products", description = "Products REST API")
@CrossOrigin
@RequestMapping(value = "/Product")
public class GetProductsController {
    @Autowired
    private ProductFindAll all;
    @GetMapping(value = "/All")
    public ResponseEntity<List<HashMap<String,Object>>> execute() {
        AllProducts response = new AllProducts(all.execute());
        return  ResponseEntity.status(HttpStatus.OK).body(response.execute());
    }
}
