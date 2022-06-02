package com.wixteam.barbershop.Products.Order.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Products.Order.Application.Update.OrderUpdate;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderDate;
import com.wixteam.barbershop.Products.Order.Domain.Exceptions.InvalidOrderStatus;
import com.wixteam.barbershop.Shared.Domain.Exceptions.InvalidCustomUUID;
import com.wixteam.barbershop.Shared.Domain.Exceptions.LengthInvalid;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.InvalidName;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.InvalidPassword;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.InvalidPhone;
import com.wixteam.barbershop.Users.User.Infraestructure.Controllers.PutUserControllers;
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
@RequestMapping(value = "/Orders")
public class PutOrderController {
    @Autowired
    private OrderUpdate update;

    @Operation(summary = "Order is update", description = "Order is update in the system", tags = {"Orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order Update"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PutMapping(value = "/Update/{OrderId}")
    public ResponseEntity execute(@PathVariable("OrderId") String id, @RequestBody OrderRequest request){
        update.execute(id,request.getOrderStatus(),request.getOrderDate());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, InvalidOrderStatus.class, InvalidOrderDate.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

     static class OrderRequest{
         @Schema(description = "Order Status, They can be 5 statuses", example = "ACEPTADO")
        @JsonProperty("OrderStatus")
        private String OrderStatus;

         @Schema(description = "Order Date", example = "26/04/2022")
         @JsonProperty("OrderDate")
         private String OrderDate;

         @Override
         public String toString() {
             return "OrderRequest{" +
                     "OrderStatus='" + OrderStatus + '\'' +
                     ", OrderDate='" + OrderDate + '\'' +
                     '}';
         }

         public String getOrderStatus() {
             return OrderStatus;
         }

         public void setOrderStatus(String orderStatus) {
             OrderStatus = orderStatus;
         }

         public String getOrderDate() {
             return OrderDate;
         }

         public void setOrderDate(String orderDate) {
             OrderDate = orderDate;
         }
     }
}
