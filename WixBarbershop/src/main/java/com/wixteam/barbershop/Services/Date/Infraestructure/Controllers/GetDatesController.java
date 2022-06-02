package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.wixteam.barbershop.Services.Date.Application.All.DateFindAll;
import com.wixteam.barbershop.Services.Date.Application.All.allDate;
import com.wixteam.barbershop.Users.User.Application.All.AllUsers;
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
@RequestMapping(value = "/Services")
public class GetDatesController {
    @Autowired
    private DateFindAll date;
    @GetMapping(value = "/Dates")
    public ResponseEntity<List<HashMap<String,Object>>> execute() {
        allDate response = new allDate(date.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
