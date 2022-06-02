package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.wixteam.barbershop.Services.Date.Application.All.allDate;
import com.wixteam.barbershop.Services.Date.Application.All.allDateCustomers;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Dates", description = "Dates REST API")
@CrossOrigin
@RequestMapping(value = "Services/Date")
public class GetCustomerDatesController {
    @Autowired
    private allDateCustomers dates;
    @GetMapping(value = "/Customers/{customerId}")
    public ResponseEntity<List<HashMap<String,Object>>>  execute(@PathVariable("customerId") String id) {
        allDate response = new allDate(dates.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
