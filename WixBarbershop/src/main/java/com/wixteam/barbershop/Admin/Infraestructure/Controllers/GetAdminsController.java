package com.wixteam.barbershop.Admin.Infraestructure.Controllers;


import com.wixteam.barbershop.Admin.Application.All.AdminFindAll;
import com.wixteam.barbershop.Admin.Application.All.AllAdmins;
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
@Tag(name = "Admin", description = "Admin REST API")
@CrossOrigin
@RequestMapping(value = "/Admin")
public class GetAdminsController {
    @Autowired
    private AdminFindAll all;
    @GetMapping(value = "/All")
    public ResponseEntity<List<HashMap<String,Object>>> execute(){
        AllAdmins response = new AllAdmins(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
 }
