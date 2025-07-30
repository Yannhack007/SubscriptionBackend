package com.example.subscription_api.common.DTO.services;

import lombok.*;

@Getter
@Setter
public class ServiceRequestDTO {
    private String name;
    private String api_key;
    private String callback_url;
}
