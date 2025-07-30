package com.example.subscription_api.common.DTO.plans;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PlanRequestDTO {
    private List<String> advantages;
    private String description;
    private BigDecimal amount;
    private Integer duration;
}
