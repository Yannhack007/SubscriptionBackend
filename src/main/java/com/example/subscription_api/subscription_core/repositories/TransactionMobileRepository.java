package com.example.subscription_api.subscription_core.repositories;

import com.example.subscription_api.subscription_core.models.TransactionMobile;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface TransactionMobileRepository extends CassandraRepository<TransactionMobile, UUID> {
}
