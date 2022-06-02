package com.wixteam.barbershop.Users.Address.Infraestructure.Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wixteam.barbershop.Shared.Infraestructure.Schema.ErrorSchema;
import com.wixteam.barbershop.Users.Address.Application.Create.AddressCreator;
import com.wixteam.barbershop.Users.Address.Domain.Exceptions.CreateAddressField;
import com.wixteam.barbershop.Users.User.Domain.Exceptions.*;
import com.wixteam.barbershop.Users.User.Infraestructure.Controllers.PostCustomerController;
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
@Tag(name = "Address", description = "Address REST API")
@CrossOrigin
@RequestMapping(value = "/Address")
public class PostAddressController {
    @Autowired
    private AddressCreator creator;

    @Operation(summary = "Create a new Address", description = "Create a new Address in the system", tags = {"Address"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Address created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Address already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })

    @PostMapping(value = "/Create/")
    public ResponseEntity<String> execute (@RequestBody AddressRequest request ){
        creator.execute(request.getAddressId(),request.getAddressDetail(),request.getAddressCity(),request.getAddressAdditionalInfo(),request.getAddressNeighborhodd(),request.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(" Address " + request.toString() );
    }

    @ExceptionHandler(CreateAddressField.class)//Se realiza para todos los controladores
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class AddressRequest{

        @Schema(description = "address id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("addressId")
        private String addressId ;

        @Schema(description = "address City", example = "Bogota")
        @JsonProperty("addressCity")
        private String addressCity ;

        @Schema(description = "address Detail", example = "Transversal 17 #46A-10")
        @JsonProperty("addressDetail")
        private String addressDetail ;

        @Schema(description = "address Additional Info", example = "Es apartamento")
        @JsonProperty("addressAdditionalInfo")
        private String addressAdditionalInfo ;

        @Schema(description = "address Neighborhodd", example = "Rosales")
        @JsonProperty("addressNeighborhodd")
        private String addressNeighborhodd ;

        @Schema(description = "User id", example = "00085c90-5caf-45d0-9992-158e86c9b76")
        @JsonProperty("userId")
        private String userId ;


        @Override
        public String toString() {
            return "AddressRequest{" +
                    "addressId='" + addressId + '\'' +
                    ", addressCity='" + addressCity + '\'' +
                    ", addressDetail='" + addressDetail + '\'' +
                    ", addressAdditionalInfo='" + addressAdditionalInfo + '\'' +
                    ", addressNeighborhodd='" + addressNeighborhodd + '\'' +
                    ", userId='"+userId+'\''+
                    '}';
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAddressId() {
            return addressId;
        }

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

        public String getAddressCity() {
            return addressCity;
        }

        public void setAddressCity(String addressCity) {
            this.addressCity = addressCity;
        }

        public String getAddressDetail() {
            return addressDetail;
        }

        public void setAddressDetail(String addressDetail) {
            this.addressDetail = addressDetail;
        }

        public String getAddressAdditionalInfo() {
            return addressAdditionalInfo;
        }

        public void setAddressAdditionalInfo(String addressAdditionalInfo) {
            this.addressAdditionalInfo = addressAdditionalInfo;
        }

        public String getAddressNeighborhodd() {
            return addressNeighborhodd;
        }

        public void setAddressNeighborhodd(String addressNeighborhodd) {
            this.addressNeighborhodd = addressNeighborhodd;
        }
    }
}
