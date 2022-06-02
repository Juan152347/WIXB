package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.wixteam.barbershop.Services.Date.Application.All.allDate;
import com.wixteam.barbershop.Services.Date.Application.All.allDateBarbers;
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
public class GetBarberDatesController {
    @Autowired
    private allDateBarbers dates;
    @GetMapping(value = "/Barbers/{BarbersId}")
    public ResponseEntity<List<HashMap<String,Object>>> execute(@PathVariable("BarbersId") String id) {
        allDate response = new allDate(dates.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
