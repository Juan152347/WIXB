package com.wixteam.barbershop.Products.Product.Infraestructure.Controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Products.Product.Application.Create.ProductCreator;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.CreateProductFailed;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidProductPrice;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidQuantity;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidRankingProduct;
import com.wixteam.barbershop.Services.Date.Domain.Exceptions.CreateDateFailed;
import com.wixteam.barbershop.Shared.Domain.Exceptions.InvalidCustomUUID;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;
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

import java.sql.*;
import java.util.HashMap;

@RestController
@Tag(name = "Products", description = "Products REST API")
@CrossOrigin
@RequestMapping(value = "/Product")
public class PostProductController {
    @Autowired
    private ProductCreator create;

    @Operation(summary = "Create a new Product", description = "Create a new Product in the system", tags = {"Products"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Product already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PostMapping(value = "/Create")
    public ResponseEntity<String> execute(@RequestBody ProductRequest request ){
        create.execute(request.getId(),request.getDescription(),request.getPrice(),request.getRating(),request.getQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body("Se creo el Producto " + request.toString());
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, CreateProductFailed.class, InvalidProductPrice.class, InvalidQuantity.class, InvalidRankingProduct.class, LengthInvalid.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class ProductRequest {
        @Schema(description = "Product id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("id")
        private String id;

        @Schema(description = "Product description", example = "Delineado de barba")
        @JsonProperty("description")
        private String description;

        @Schema(description = "Product price", example = "15000")
        @JsonProperty("price")
        private double price;

        @Schema(description = "Product quantity, greater than 0", example = "2")
        @JsonProperty("quantity")
        private int quantity;

        @Schema(description = "Product rating, between 1 and 5", example = "2")
        @JsonProperty("rating")
        private int rating;

        public String getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public String toString() {
            return "ProductRequest{" +
                    "id='" + id + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", rating=" + rating +
                    '}';
        }
    }

}
