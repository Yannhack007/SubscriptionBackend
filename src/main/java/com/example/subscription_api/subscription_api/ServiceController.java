package com.example.subscription_api.subscription_api;

import com.example.subscription_api.common.DTO.services.ServiceRequestDTO;
import com.example.subscription_api.subscription_core.models.Services;
import com.example.subscription_api.subscription_core.services.ServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/service")
@CrossOrigin
@Tag(name = "Services Controller", description = "APIs for managing services")
@Validated
@AllArgsConstructor
public class ServiceController {
    private ServiceInterface serviceInterface;

    @PostMapping
    @Operation(summary = "Create Service")
    public ResponseEntity<Services> createService(@RequestBody ServiceRequestDTO service){
        return ResponseEntity.ok(serviceInterface.create(service));
    }

    @PutMapping
    @Operation(summary = "Update Service")
    public ResponseEntity<Services> updateService(@RequestBody ServiceRequestDTO service, @RequestHeader("X-SERVICE-ID") UUID serviceId){
        return ResponseEntity.ok(serviceInterface.update(service,serviceId));
    }

//    @DeleteMapping
//    @Operation(summary = "Delete Service")
    public ResponseEntity<Void> deleteService(UUID serviceId){
        serviceInterface.delete(serviceId);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    @Operation(summary = "Get All Service")
    public ResponseEntity<List<Services>> getAllService(){
        return ResponseEntity.ok(serviceInterface.getList());
    }


}
