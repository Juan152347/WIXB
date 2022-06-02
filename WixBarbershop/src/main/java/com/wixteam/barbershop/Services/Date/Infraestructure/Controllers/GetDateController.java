package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.wixteam.barbershop.Services.Date.Application.Find.dateFind;
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
@RequestMapping(value = "/Services/Date")
public class GetDateController {
    @Autowired
    private dateFind find;
    @GetMapping(value = "/{DateId}")
    public ResponseEntity execute(@PathVariable("DateId") String id) {
        HashMap<String,Object> date = find.execute(id).data();
        return ResponseEntity.status(HttpStatus.OK).body("Se encontro la cita con id " + date.toString() );
    }
}
