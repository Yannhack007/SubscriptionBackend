package com.example.subscription_api.subscription_payment.impl;

import com.example.subscription_api.common.DTO.Transaction.Mobile.MobilePaymentResponse;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentResponseCallback;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentStatusResponse;
import com.example.subscription_api.common.DTO.subscriptions.SubscriptionUpdateRequest;
import com.example.subscription_api.subscription_core.services.SubscriptionInterface;
import com.example.subscription_api.subscription_core.type.Status;
import com.example.subscription_api.subscription_payment.InitMobilePaymentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
@RequiredArgsConstructor

public class InitMobilePaymentImpl implements InitMobilePaymentInterface {
    private final WebClient mobilePaymentServiceWebClient;
    private SubscriptionInterface subscriptionInterface;
    public Mono<MobilePaymentResponse> InitPayment(PaymentMobileRequest mobileRequest) {
        return mobilePaymentServiceWebClient
                .post()
                .uri("/payin")
                .bodyValue(mobileRequest)
                .retrieve()
                .bodyToMono(MobilePaymentResponse.class);
    }
    public Mono<PaymentStatusResponse> CheckTransactionStatus(UUID transactionCode){
        return mobilePaymentServiceWebClient
                .get()
                .uri("/transactions/{transaction_code}/status", transactionCode)
                .retrieve()
                .bodyToMono(PaymentStatusResponse.class);
    }
    public void handleCallbackResponse(PaymentResponseCallback callback){
        SubscriptionUpdateRequest request = new SubscriptionUpdateRequest();
        request.setTransactionId(UUID.fromString(callback.getTransactionReference()));
        request.setStatus(Status.ACTIVE.toString());

        subscriptionInterface.update(request);
    }
}
