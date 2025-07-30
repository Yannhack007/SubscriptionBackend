package com.example.subscription_api.subscription_core.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import com.example.subscription_api.subscription_core.absctract.AbstractModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table("plan")
public class Plan extends AbstractModel {
    @PrimaryKey
    @Id
    private UUID plan_id;
    private List<String> advantages;
    private String description;
    private BigDecimal amount;
    private Integer duration;
    @Column("service_id")
    private UUID serviceId;

}
