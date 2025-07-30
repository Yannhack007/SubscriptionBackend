package com.example.subscription_api.subscription_core.repositories;

import com.example.subscription_api.subscription_core.models.Services;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ServiceRepository extends CassandraRepository<Services, UUID> {
}
