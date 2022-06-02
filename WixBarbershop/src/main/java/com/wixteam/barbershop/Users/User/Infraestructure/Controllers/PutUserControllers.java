package com.wixteam.barbershop.Users.User.Infraestructure.Controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.User.Application.Update.userUpdate;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Users")
@CrossOrigin
public class PutUserControllers {
    @Autowired
    private userUpdate update;

    @Operation(summary = " Customer is update", description = "Customer is update in the system", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer Update"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PutMapping(value = "/Update/{UserId}")
    public ResponseEntity execute(@PathVariable("UserId") String id, @RequestBody CustomerRequest request){
        update.execute(id, request.getUsername(), request.getPassword(), request.getPhone());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(value = { InvalidPassword.class, InvalidName.class, InvalidPhone.class, LengthInvalid.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class CustomerRequest{

        @Schema(description = "User Phone, it is of the 10 characters", example = "3242345678")
        @JsonProperty("phone")
        private String phone;

        @Schema(description = "User Name,  between 2 and 20 characters, has no special characters", example = "Messi")
        @JsonProperty("username")
        private String username ;

        @Schema(description = "User password, must have more than 8 characters,requires at least one space character", example = "12345*Dembo")
        @JsonProperty("password")
        private String password;

        @Override
        public String toString() {
            return "CustomerRequest{" +
                    ", phone='" + phone + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
