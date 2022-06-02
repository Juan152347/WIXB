package com.wixteam.barbershop.Products.Order.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Products.Order.Application.Create.OrderCreator;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.CreateOrderFailed;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderDate;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderStatus;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderValue;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.CreateProductFailed;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidProductPrice;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidQuantity;
import com.wixteam.barbershop.Products.Product.Domain.Exceptions.InvalidRankingProduct;
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

import java.util.HashMap;

@RestController
@Tag(name = "Orders", description = "Orders REST API")
@CrossOrigin
@RequestMapping(value = "/Products")
public class PostOrderController {

    @Autowired
    private OrderCreator creator;

    @Operation(summary = "Create a new Order", description = "Create a new Order in the system", tags = {"Orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Order already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PostMapping(value = "/Order")
    public ResponseEntity execute(@RequestBody OrderRequest request ){
        creator.execute(request.getIdOrder(),request.getStatus(),request.getOrdenDate());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, CreateOrderFailed.class, InvalidOrderDate.class, InvalidOrderValue.class, InvalidOrderStatus.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class OrderRequest{
        @Schema(description = "Order Date", example = "26/04/2022")
        @JsonProperty("OrdenDate")
        private String OrdenDate;

        @Schema(description = "Order id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("idOrder")
        private String idOrder;

        @Schema(description = "Order Status, They can be 5 statuses", example = "ACEPTADO")
        @JsonProperty("Status")
        private String Status;

        public OrderRequest() {
        }

        @Override
        public String toString() {
            return "OrderRequest{" +
                    "OrdenDate='" + OrdenDate + '\'' +
                    ", idOrder='" + idOrder + '\'' +
                    ", Status='" + Status + '\'' +
                    '}';
        }

        public String getOrdenDate() {
            return OrdenDate;
        }

        public void setOrdenDate(String ordenDate) {
            OrdenDate = ordenDate;
        }

        public String getIdOrder() {
            return idOrder;
        }

        public void setIdOrder(String idOrder) {
            this.idOrder = idOrder;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }
    }
}
