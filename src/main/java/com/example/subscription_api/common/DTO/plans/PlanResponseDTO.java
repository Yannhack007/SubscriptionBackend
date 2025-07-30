package com.example.subscription_api.common.DTO.plans;

import com.example.subscription_api.subscription_core.models.Plan;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PlanResponseDTO {
    private List<String> advantages;
    private String description;
    private BigDecimal amount;
    private Integer duration;
    private UUID service_id;

    public PlanResponseDTO(Plan p){
        this.service_id = p.getServiceId();
        this.advantages = p.getAdvantages();
        this.amount = p.getAmount();
        this.description = p.getDescription();
        this.duration = p.getDuration();
    }
}
