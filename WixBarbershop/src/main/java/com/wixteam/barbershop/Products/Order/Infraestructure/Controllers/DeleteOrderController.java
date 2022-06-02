package com.wixteam.barbershop.Products.Order.Infraestructure.Controllers;

import com.wixteam.barbershop.Products.Order.Application.Delete.OrderDelete;
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
@Tag(name = "Orders", description = "Orders REST API")
@CrossOrigin
@RequestMapping(value = "/Orders")
public class DeleteOrderController {
    @Autowired
    private OrderDelete delete;

    @Operation(summary = "Delete Order", description = "Delete Order of the system", tags = {"Orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order Delete"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })

    @DeleteMapping(value = "/Delete/{OrderId}")
    public ResponseEntity execute(@PathVariable("OrderId") String id) {
        delete.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(InvalidCustomUUID.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
