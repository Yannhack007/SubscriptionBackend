package com.example.subscription_api.subscription_core.services;


import com.example.subscription_api.common.DTO.plans.PlanRequestDTO;
import com.example.subscription_api.common.DTO.plans.PlanResponseDTO;
import com.example.subscription_api.subscription_core.models.Plan;

import java.util.List;
import java.util.UUID;

public interface PlanInterface {
    PlanResponseDTO create(PlanRequestDTO request, UUID service_id);
    PlanResponseDTO update(PlanRequestDTO request, UUID plan_id);
    void delete(UUID id);
    List<Plan> getList(UUID service_id);
}
