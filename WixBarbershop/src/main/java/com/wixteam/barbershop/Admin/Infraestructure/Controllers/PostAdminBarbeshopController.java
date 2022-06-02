package com.wixteam.barbershop.Admin.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Admin.Application.Create.AdminCreator;
import com.wixteam.barbershop.Admin.Domain.Exceptions.CreateAdminFailed;
import com.wixteam.barbershop.Admin.Domain.Exceptions.InvalidNameAdmin;
import com.wixteam.barbershop.Admin.Domain.Exceptions.InvalidPasswordAdmin;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.CreateOrderFailed;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderDate;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderStatus;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderValue;
import com.wixteam.barbershop.Shared.Domain.Exceptions.InvalidCustomUUID;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
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
@Tag(name = "Admin", description = "Admin REST API")
@CrossOrigin
@RequestMapping(value = "/Admin")
public class PostAdminBarbeshopController {

    @Autowired
    private AdminCreator create;

    @Operation(summary = "Create a new Admin", description = "Create a new Admin in the system", tags = {"Admin"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Admin already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PostMapping(value = "/Create")
    public ResponseEntity execute(@RequestBody AdminRequest request ){
        create.execute(request.getId(),request.getName(),request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, CreateAdminFailed.class, InvalidNameAdmin.class, InvalidPasswordAdmin.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class AdminRequest{

        @Schema(description = "Admin id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("id")
        private String id;

        @Schema(description = "Admin Name,  between 2 and 20 characters, has no special characters", example = "Messi")
        @JsonProperty("name")
        private String name;

        @Schema(description = "Admin password, must have more than 8 characters,requires at least one space character", example = "12345*Dembo")
        @JsonProperty("password")
        private String password;

        public AdminRequest() {}

        @Override
        public String toString() {
            return "AdminRequest{" +
                    "id" + id + "\'" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getId(){ return id; }

        public void setId(String id){ this.id = id; }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
