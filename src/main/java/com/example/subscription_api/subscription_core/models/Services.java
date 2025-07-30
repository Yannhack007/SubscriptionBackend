package com.example.subscription_api.subscription_core.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.*;
import com.example.subscription_api.subscription_core.absctract.AbstractModel;

import java.util.UUID;

@Getter
@Setter
@Table("service")
public class Services extends AbstractModel {
    @PrimaryKey
    @Id
    private UUID service_id;
    private String name;
    private String api_key;
    private String callback_url;
}
