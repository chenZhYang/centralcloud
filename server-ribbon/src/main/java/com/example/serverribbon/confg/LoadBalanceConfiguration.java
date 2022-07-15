package com.example.serverribbon.confg;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalanceConfiguration {
    @Bean
    public IRule rule() {
        return new RoundRobinRule();
    }
}
