package com.example.subscription_api.subscription_api;

import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.subscription_core.models.Subscription;
import com.example.subscription_api.subscription_core.services.SubscriptionInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subscription")
@CrossOrigin
@Tag(name = "Subscription Controller", description = "APIs for managing subscriptions")
@Validated
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionInterface subscriptionInterface;

    @PostMapping("/{planId}")
    @Operation(summary = "Create subscription")
    public ResponseEntity<Subscription> createSubscription(@RequestBody PaymentMobileRequest request, @PathVariable UUID planId){
        return ResponseEntity.ok(subscriptionInterface.createMobile(request,planId));
    }

    @GetMapping
    @Operation(summary = "Get All Plans")
    public ResponseEntity<List<Subscription>> getAllSubscription (@RequestHeader("X-SERVICE-ID") UUID serviceId){
        return ResponseEntity.ok(subscriptionInterface.getList(serviceId));
    }
}
