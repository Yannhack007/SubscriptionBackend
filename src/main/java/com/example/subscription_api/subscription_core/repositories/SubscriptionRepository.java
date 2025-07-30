package com.example.subscription_api.subscription_core.repositories;

import com.example.subscription_api.subscription_core.models.Subscription;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends CassandraRepository<Subscription, UUID> {
    List<Subscription> findByPlanId(UUID planId);
    Subscription findByTransactionId(UUID transactionId);
}
