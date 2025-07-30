package com.example.subscription_api.subscription_core.services.impl;

import com.example.subscription_api.common.DTO.plans.PlanRequestDTO;
import com.example.subscription_api.common.DTO.plans.PlanResponseDTO;
import com.example.subscription_api.common.exceptions.ResourceNotFoundException;
import com.example.subscription_api.common.helpers.TimestampUtil;
import com.example.subscription_api.subscription_core.models.Plan;
import com.example.subscription_api.subscription_core.repositories.PlanRepository;
import com.example.subscription_api.subscription_core.services.PlanInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.CassandraInvalidQueryException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlanImpl implements PlanInterface {
    private PlanRepository planRepository;

    public PlanResponseDTO create(PlanRequestDTO request, UUID service_id){
        try{
            Plan p = new Plan();
            p.setPlan_id(UUID.randomUUID());
            p.setServiceId(service_id);
            p.setAdvantages(request.getAdvantages());
            p.setAmount(request.getAmount());
            p.setDescription(request.getDescription());
            p.setDuration(request.getDuration());
            TimestampUtil.markCreated(p);
            TimestampUtil.markUpdated(p);
            planRepository.save(p);

            return new PlanResponseDTO(p);
        } catch (Exception e) {
            throw new CassandraInvalidQueryException("Failed to save : ",e);
        }
    }
    public PlanResponseDTO update(PlanRequestDTO request, UUID plan_id){
        Optional<Plan> optionalPlan = planRepository.findById(plan_id);
        if (optionalPlan.isEmpty()) {
            throw new ResourceNotFoundException("Plan with ID: " + plan_id+ " does not exist");
        }

        Plan existingPlan = optionalPlan.get();

        if (request.getAdvantages()!=null){
           existingPlan.setAdvantages(request.getAdvantages());
        }
        if (request.getAmount()!=null){
            existingPlan.setAmount(request.getAmount());
        }
        if (request.getDescription()!=null){
            existingPlan.setDescription(request.getDescription());
        }
        if (request.getDuration()!=null){
            existingPlan.setDuration(request.getDuration());
        }
        TimestampUtil.markUpdated(existingPlan);
        planRepository.save(existingPlan);

        return new PlanResponseDTO(existingPlan);

    }
    public void delete(UUID id){
        Optional<Plan> optionalPlan = planRepository.findById(id);
        if (optionalPlan.isEmpty()) {
            throw new ResourceNotFoundException("Plan with ID: " + id + " does not exist");
        }
        planRepository.deleteById(id);
    }
    public List<Plan> getList(UUID service_id){
        return planRepository.findByServiceId(service_id);
    }
}
