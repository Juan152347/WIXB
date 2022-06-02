package com.wixteam.barbershop.Users.Address.Infraestructure.Controllers;


import com.wixteam.barbershop.Users.Address.Application.All.AddressFindAll;
import com.wixteam.barbershop.Users.Address.Application.All.AllAddress;
import com.wixteam.barbershop.Users.User.Application.All.UserFindAll;
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
@Tag(name = "Address", description = "Address REST API")
@CrossOrigin
@RequestMapping(value = "/Address")
public class GetAddressController {
    @Autowired
    private AddressFindAll all;
    @GetMapping(value = "/All")
    public ResponseEntity<List<HashMap<String,Object>>> execute() {
        AllAddress response = new AllAddress(all.execute());
        return  ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
