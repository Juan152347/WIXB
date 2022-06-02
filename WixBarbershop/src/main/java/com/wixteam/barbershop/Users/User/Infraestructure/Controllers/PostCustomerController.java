package com.wixteam.barbershop.Users.User.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Shared.Domain.Exceptions.InvalidCustomUUID;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.User.Application.Create.UserCustomerCreator;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@Tag(name = "Users", description = "Users REST API")
@RequestMapping(value = "/Users")
public class PostCustomerController {
    @Autowired
    private UserCustomerCreator creator;

    @Operation(summary = "Create a new Customer", description = "Create a new Customer in the system", tags = {"Users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Customer already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })


    @PostMapping(value = "/Customer/Create/")
    public ResponseEntity execute (@RequestBody CustomerRequest request ){
        creator.execute( request.getUserId(), request.getUsername(), request.getPassword(), request.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class,CreateUserFailed.class, InvalidPassword.class, InvalidName.class, InvalidPhone.class, LengthInvalid.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    static class CustomerRequest{

        @Schema(description = "User id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("userId")
        private String userId ;

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
                    "userId='" + userId + '\'' +
                    ", phone='" + phone + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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
