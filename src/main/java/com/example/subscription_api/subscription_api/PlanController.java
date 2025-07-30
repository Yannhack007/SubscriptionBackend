package com.example.subscription_api.subscription_api;

import com.example.subscription_api.common.DTO.plans.PlanRequestDTO;
import com.example.subscription_api.common.DTO.plans.PlanResponseDTO;
import com.example.subscription_api.subscription_core.models.Plan;
import com.example.subscription_api.subscription_core.services.PlanInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/plans")
@CrossOrigin
@Tag(name = "Plan Controller", description = "APIs for managing plans")
@Validated
@AllArgsConstructor
public class PlanController {
    private final PlanInterface planService;

    @GetMapping
    @Operation(summary = "Get All Plans")
    public ResponseEntity<List<Plan>> getPlanByService(@RequestHeader("X-SERVICE-ID") UUID service_id) {
        return ResponseEntity.ok(planService.getList(service_id));
    }


    @PostMapping
    @Operation(summary = "Create Plan")
    public ResponseEntity<PlanResponseDTO> createPlan(
            @RequestBody PlanRequestDTO request,
            @RequestHeader("X-SERVICE-ID") UUID service_id) {

        PlanResponseDTO createdPlan = planService.create(request, service_id);
        return ResponseEntity.ok(createdPlan);
    }

    @PutMapping("/{planId}")
    @Operation(summary = "Update Plan")
    public ResponseEntity<PlanResponseDTO> updatePlan(@RequestBody PlanRequestDTO request,@PathVariable UUID plan_id) {
        PlanResponseDTO updatedPlan = planService.update(request,plan_id);
        return ResponseEntity.ok(updatedPlan);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Plan By ID")
    public ResponseEntity<Void> deletePlan(@PathVariable UUID id) {
        planService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
