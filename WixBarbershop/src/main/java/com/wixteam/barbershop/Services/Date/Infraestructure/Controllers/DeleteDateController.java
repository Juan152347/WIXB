package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.wixteam.barbershop.Services.Date.Application.Delete.DateDelete;
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
@Tag(name = "Dates", description = "Dates REST API")
@CrossOrigin
@RequestMapping(value = "Services/Date")
public class DeleteDateController {
    @Autowired
    private DateDelete delete;

    @Operation(summary = "Delete Date", description = "Delete Date of the system", tags = {"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Date Delete"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })

    @DeleteMapping(value = "Delete/{DateId}")
    public ResponseEntity execute(@PathVariable("DateId") String id) {
        delete.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body( null );
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
