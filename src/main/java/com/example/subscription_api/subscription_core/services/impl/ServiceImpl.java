package com.example.subscription_api.subscription_core.services.impl;

import com.example.subscription_api.common.DTO.services.ServiceRequestDTO;
import com.example.subscription_api.common.exceptions.ResourceNotFoundException;
import com.example.subscription_api.common.helpers.TimestampUtil;
import com.example.subscription_api.subscription_core.models.Plan;
import com.example.subscription_api.subscription_core.models.Services;
import com.example.subscription_api.subscription_core.repositories.ServiceRepository;
import com.example.subscription_api.subscription_core.services.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceImpl implements ServiceInterface {
    @Autowired
    private ServiceRepository serviceRepository;


    public Services create(ServiceRequestDTO service){
        try{
            Services s = new Services();
            s.setService_id(UUID.randomUUID());
            s.setName(service.getName());
            s.setApi_key(service.getApi_key());
            s.setCallback_url(service.getCallback_url());
            TimestampUtil.markCreated(s);
            TimestampUtil.markUpdated(s);
            return serviceRepository.save(s);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public Services update(ServiceRequestDTO service, UUID serviceId){
        Optional<Services> optionalServices = serviceRepository.findById(serviceId);
        if (optionalServices.isEmpty()) {
            throw new ResourceNotFoundException("Service with ID: " + serviceId+ " does not exist");
        }

        Services existingServices = optionalServices.get();
        if (service.getName()!=null){
            existingServices.setName(service.getName());
        }
        if (service.getCallback_url()!=null){
            existingServices.setCallback_url(service.getCallback_url());
        }
        if (service.getApi_key()!=null){
            existingServices.setApi_key(service.getApi_key());
        }
        TimestampUtil.markUpdated(existingServices);
        return serviceRepository.save(existingServices);
    }
    public void delete (UUID serviceId){
        Optional<Services> existingServices = serviceRepository.findById(serviceId);
        if (existingServices.isEmpty()) {
            throw new ResourceNotFoundException("Service with ID: " + serviceId+ " does not exist");
        }

        serviceRepository.deleteById(serviceId);
    }
    public List<Services> getList(){
        return serviceRepository.findAll();
    }
}
