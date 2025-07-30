package com.example.subscription_api.subscription_core.services;

import com.example.subscription_api.common.DTO.services.ServiceRequestDTO;
import com.example.subscription_api.subscription_core.models.Services;

import java.util.List;
import java.util.UUID;

public interface ServiceInterface {
    Services create(ServiceRequestDTO service);
    Services update(ServiceRequestDTO service, UUID serviceId);
    void delete (UUID serviceId);
    List<Services> getList();
}
