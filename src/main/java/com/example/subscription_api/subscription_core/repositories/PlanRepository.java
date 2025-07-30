package com.example.subscription_api.subscription_core.repositories;

import com.example.subscription_api.subscription_core.models.Plan;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface PlanRepository extends CassandraRepository<Plan, UUID> {
    List<Plan> findByServiceId(UUID serviceId);
}
