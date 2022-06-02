package com.wixteam.barbershop.Services.Date.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Services.Date.Application.Create.dateCreate;
import com.wixteam.barbershop.Services.Date.Domain.Exceptions.CreateDateFailed;
import com.wixteam.barbershop.Shared.Domain.Exceptions.InvalidCustomUUID;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.Address.Domain.Exceptions.CreateAddressField;
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
@RequestMapping(value = "/Services")
public class PostDateController {
    @Autowired
    private dateCreate create;

    @Operation(summary = "Create a new Date", description = "Create a new Date in the system", tags = {"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Date created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Date already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PostMapping(value = "/Date/Create")
    public ResponseEntity execute(@RequestBody DateRequest request ){
        create.execute(request.getIdDate(),request.getCustomerId(),request.getBarbersId(),request.getTypeService(),request.getServiceId(),request.getDate(), request.getAddId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, CreateDateFailed.class})//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class DateRequest{
        @Schema(description = "Date id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("Iddate")
        private String IdDate;

        @Schema(description = "Customer id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("customerId")
        private String customerId;

        @Schema(description = "barber id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("barbersId")
        private String barbersId;

        @Schema(description = "Service id", example = "BARBERIA")
        @JsonProperty("typeService")
        private String typeService;

        @Schema(description = "Service id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("ServiceId")
        private String ServiceId;

        @Schema(description = "Address id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("addId")
        private String addId;

        @Schema(description = "Date", example = "Mayo 10/23/45 12:30 ")
        @JsonProperty("date")
        private String date;

        public String getAddId() {
            return addId;
        }

        public void setAddId(String addId) {
            this.addId = addId;
        }

        public DateRequest() {
        }

        @Override
        public String toString() {
            return "DateRequest{" +
                    "IdDate='" + IdDate + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", barbersId='" + barbersId + '\'' +
                    ", typeService='" + typeService + '\'' +
                    ", ServiceId='" + ServiceId + '\'' +
                    ", addId='" + addId + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }

        public String getIdDate() {
            return IdDate;
        }

        public void setIdDate(String idDate) {
            IdDate = idDate;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getBarbersId() {
            return barbersId;
        }

        public void setBarbersId(String barbersId) {
            this.barbersId = barbersId;
        }

        public String getTypeService() {
            return typeService;
        }

        public void setTypeService(String typeService) {
            this.typeService = typeService;
        }

        public String getServiceId() {
            return ServiceId;
        }

        public void setServiceId(String serviceId) {
            ServiceId = serviceId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
