package com.example.subscription_api.subscription_core.models;

import com.example.subscription_api.subscription_core.absctract.AbstractModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Table("transaction")
public class TransactionMobile extends AbstractModel {
    @PrimaryKey
    @Id
    private UUID transaction_id;
    private BigDecimal transaction_amount;
    private String transaction_currency;
    private String payment_method;
    private String payer_reference;
    private String payer_name;
    private String payer_email;
    private UUID service_reference ;
    private String service_name ;
}
