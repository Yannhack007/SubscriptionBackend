package com.example.subscription_api.common.DTO.Transaction.Mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class PaymentDataStatus {
    @JsonProperty("transaction_ref")
    private String TransactionRef;
    @JsonProperty("transaction_amount")
    private String TransactionAmount;
    @JsonProperty("transaction_fees")
    private String TransactionFees;
    @JsonProperty("transaction_currency")
    private String TransactionCurrency;
    @JsonProperty("payer_reference")
    private String PayerReference;
    @JsonProperty("payer_name")
    private String PayerName;
    @JsonProperty("payer_email")
    private String PayerEmail;
    @JsonProperty("payer_phone")
    private String PayerPhone;
    @JsonProperty("transaction_method")
    private String TransactMethod;
    @JsonProperty("app_transaction_reference")
    private String AppReference;
    @JsonProperty("status")
    private String status;
}