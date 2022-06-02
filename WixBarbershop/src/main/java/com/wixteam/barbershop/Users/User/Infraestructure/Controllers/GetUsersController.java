package com.wixteam.barbershop.Users.User.Infraestructure.Controllers;

import com.wixteam.barbershop.Users.User.Application.All.AllUsers;
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
@Tag(name = "Users", description = "Users REST API")
@CrossOrigin
@RequestMapping(value = "/Users")
public class GetUsersController {
    @Autowired
    private UserFindAll all;
    @GetMapping(value = "/All")
    public ResponseEntity<List<HashMap<String,Object>>> execute() {
        AllUsers response = new AllUsers(all.execute());
        return  ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
