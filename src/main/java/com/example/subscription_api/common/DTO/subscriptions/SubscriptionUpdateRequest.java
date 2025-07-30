package com.example.subscription_api.common.DTO.subscriptions;

import com.example.subscription_api.subscription_core.type.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SubscriptionUpdateRequest {
    private UUID transactionId;
    private String status;
}
