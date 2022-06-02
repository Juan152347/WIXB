package com.wixteam.barbershop.Services.Service.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Services.Service.Application.Update.ServiceUpdate;
import com.wixteam.barbershop.Services.Service.Domain.Exceptions.CreateServiceFailed;
import com.wixteam.barbershop.Services.Service.Domain.Exceptions.InvalidPriceService;
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
@Tag(name = "Services", description = "Services REST API")
@CrossOrigin
@RequestMapping(value = "/Services")
public class PutServiceController {
    @Autowired
    private ServiceUpdate update;

    @Operation(summary = "Service is update", description = "Service is update in the system", tags = {"Services"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Services Update"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PutMapping(value = "/Update/{ServiceId}")
    public ResponseEntity execute(@PathVariable("ServiceId") String id, @RequestBody ServiceRequest request){
        update.execute(id, request.getServicePrice(), request.getServiceDetails());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, InvalidPriceService.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class ServiceRequest {

        @Schema(description = "User id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("serviceId")
        private String serviceId ;

        @Schema(description = "service Price", example = "12345")
        @JsonProperty("servicePrice")
        private double servicePrice;

        @Schema(description = "service Details", example = "Solo corte")
        @JsonProperty("serviceDetails")
        private String serviceDetails ;

        @Override
        public String toString() {
            return "ServiceRequest{" +
                    "serviceId='" + serviceId + '\'' +
                    ", servicePrice='" + servicePrice + '\'' +
                    ", serviceDetails='" + serviceDetails + '\'' +
                    '}';
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public double getServicePrice() {
            return servicePrice;
        }

        public void setServicePrice(double servicePrice) {
            this.servicePrice = servicePrice;
        }

        public String getServiceDetails() {
            return serviceDetails;
        }

        public void setServiceDetails(String serviceDetails) {
            this.serviceDetails = serviceDetails;
        }
    }
}
