package co.com.dostawa.servicerouteoptimization.application.config;

import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OptimizationGateway;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OrderRepository;
import co.com.dostawa.servicerouteoptimization.domain.usecase.OrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderCaseConfig {
    @Bean
    public OrderUseCase orderUseCase(OrderRepository orderRepository, OptimizationGateway optimizationGateway) {
        return new OrderUseCase(orderRepository, optimizationGateway);
    }
}
