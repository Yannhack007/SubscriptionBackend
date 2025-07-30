package com.example.subscription_api.subscription_core.services;

import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.subscription_core.models.TransactionMobile;

public interface TransactionMobileInterface {
    TransactionMobile create(PaymentMobileRequest transactionRequest);
}
