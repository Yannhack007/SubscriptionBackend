package com.example.subscription_api.common.helpers;

import com.example.subscription_api.subscription_core.absctract.AbstractModel;

import java.time.LocalDateTime;

public class TimestampUtil {
    public static void markCreated(AbstractModel model) {
        LocalDateTime now = LocalDateTime.now();
        model.setCreated_at(now);
        model.setUpdated_at(now);
    }

    public static void markUpdated(AbstractModel model) {
        model.setUpdated_at(LocalDateTime.now());
    }
}

