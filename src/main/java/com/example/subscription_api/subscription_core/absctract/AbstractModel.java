package com.example.subscription_api.subscription_core.absctract;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractModel {
    protected LocalDateTime created_at;
    protected LocalDateTime updated_at;
}
