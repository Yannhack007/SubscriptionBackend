package com.example.subscription_api.configurations;

import com.datastax.oss.driver.api.core.CqlSession;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetSocketAddress;
import java.util.Objects;

@Configuration
@AllArgsConstructor
public class CassandraConfig {
    private final Environment env;
    @Bean
    public CqlSession cqlSession(){
        return CqlSession.builder()
                .withKeyspace(Objects.requireNonNull(env.getProperty("spring.cassandra.keyspace-name")))
                .withAuthCredentials(Objects.requireNonNull(env.getProperty("spring.cassandra.username")), Objects.requireNonNull(env.getProperty("spring.cassandra.password")))
                .withLocalDatacenter(Objects.requireNonNull(env.getProperty("spring.cassandra.local-datacenter")))
                .addContactPoint(new InetSocketAddress(Objects.requireNonNull(env.getProperty("spring.cassandra.contact-points")),Integer.parseInt(Objects.requireNonNull(env.getProperty("spring.cassandra.port")))
                ))
                .build();
    }
}
