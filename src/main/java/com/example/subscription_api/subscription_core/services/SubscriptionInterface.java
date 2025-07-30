package com.example.subscription_api.subscription_core.services;

import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.common.DTO.subscriptions.SubscriptionUpdateRequest;
import com.example.subscription_api.subscription_core.models.Subscription;

import java.util.List;
import java.util.UUID;

public interface SubscriptionInterface {
    Subscription createMobile(PaymentMobileRequest request,UUID planId);
//    Subscription createCard(PaymentMobileRequest request);
//    Subscription createPaypal(PaymentMobileRequest request);
    List<Subscription> getList(UUID serviceId);
    Subscription update(SubscriptionUpdateRequest request);

}
