package com.example.subscription_api.subscription_payment;

import com.example.subscription_api.common.DTO.Transaction.Mobile.MobilePaymentResponse;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentResponseCallback;
import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentStatusResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface InitMobilePaymentInterface {
    Mono<MobilePaymentResponse> InitPayment(PaymentMobileRequest mobileRequest);
    Mono<PaymentStatusResponse> CheckTransactionStatus(UUID transactionCode);
    void handleCallbackResponse(PaymentResponseCallback callback);
}
