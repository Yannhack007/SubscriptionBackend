package com.example.subscription_api.common.DTO.subscriptions;

import com.example.subscription_api.subscription_core.type.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SubscriptionCreateRequest {
    private String client_id;
    private UUID plan_id;
    private Status status;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private UUID transaction_id;
}
