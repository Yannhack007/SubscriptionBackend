package com.example.subscription_api.subscription_core.models;

import com.example.subscription_api.subscription_core.absctract.AbstractModel;
import com.example.subscription_api.subscription_core.type.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Table("subscription")
public class Subscription extends AbstractModel {
    @PrimaryKey
    @Id
    private UUID subscription_id;
    private String client_id;
    private UUID planId;
    private String status;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    @Column("transaction_id")
    private UUID transactionId;
}
