package com.wixteam.barbershop.Products.Order.Infraestructure.Controllers;

import com.wixteam.barbershop.Products.Order.Application.All.AllOrders;
import com.wixteam.barbershop.Products.Order.Application.All.OrderFindAll;
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
@Tag(name = "Orders", description = "Orders REST API")
@CrossOrigin
@RequestMapping(value = "/Orders")
public class GetOrderController {
    @Autowired
    private OrderFindAll all;

    @GetMapping(value = "/All")
    public ResponseEntity<List<HashMap<String,Object>>> execute() {
        AllOrders response = new AllOrders(all.execute());
        return  ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
