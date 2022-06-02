package com.wixteam.barbershop.Users.User.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.User.Application.Login.loginUser;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Users", description = "Users REST API")
@CrossOrigin
@RequestMapping(value = "/Users")
public class PostLoginController {
    @Autowired
    private loginUser log;

    @Operation(summary = "Authenticated a User", description = "Authenticated a User in the system", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authenticated in the system"),
            @ApiResponse(responseCode = "401", description = "Unauthorized user", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })

    @PostMapping(value = "/Login")
    public ResponseEntity<HashMap<String,Object>> execute(@RequestBody LoginRequest request ){
        HashMap<String,Object> response = log.execute(request.getName(), request.getPasword());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @ExceptionHandler(value = {InvalidPassword.class, InvalidName.class, LengthInvalid.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class LoginRequest{

        @Schema(description = "User Name,  between 2 and 20 characters, has no special characters", example = "Messi")
        @JsonProperty("name")
        private String name;

        @Schema(description = "User password, must have more than 8 characters,requires at least one space character", example = "12345*Dembo")
        @JsonProperty("Pasword")
        private String Pasword;

        @Override
        public String toString() {
            return "LoginRequest{" +
                    "Nombre='" + name + '\'' +
                    ", Pasword='" + Pasword + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPasword() {
            return Pasword;
        }

        public void setPasword(String pasword) {
            Pasword = pasword;
        }
    }
}
