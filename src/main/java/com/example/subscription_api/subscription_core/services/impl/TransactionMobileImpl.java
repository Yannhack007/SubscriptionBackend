package com.example.subscription_api.subscription_core.services.impl;

import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.common.helpers.TimestampUtil;
import com.example.subscription_api.subscription_core.models.TransactionMobile;
import com.example.subscription_api.subscription_core.repositories.TransactionMobileRepository;
import com.example.subscription_api.subscription_core.services.TransactionMobileInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@AllArgsConstructor
public class TransactionMobileImpl implements TransactionMobileInterface {
    TransactionMobileRepository transactionRepository;
    public TransactionMobile create(PaymentMobileRequest transactionRequest){
        TransactionMobile transaction = new TransactionMobile();
        transaction.setTransaction_id(transactionRequest.getTransaction_reference());
        transaction.setTransaction_amount(transactionRequest.getTransaction_amount());
        transaction.setTransaction_currency(transactionRequest.getTransaction_currency());
        transaction.setPayer_email(transactionRequest.getPayer_email());
        transaction.setPayer_name(transactionRequest.getPayer_name());
        transaction.setPayer_reference(transactionRequest.getPayer_reference());
        transaction.setPayment_method(transactionRequest.getTransaction_method());
        transaction.setService_name(transactionRequest.getService_name());
        transaction.setService_reference(UUID.fromString(transactionRequest.getService_reference()));
        TimestampUtil.markCreated(transaction);
        TimestampUtil.markUpdated(transaction);
        return transactionRepository.save(transaction);
    }
}
