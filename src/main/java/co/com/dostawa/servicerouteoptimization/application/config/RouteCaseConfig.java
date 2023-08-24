package co.com.dostawa.servicerouteoptimization.application.config;

import co.com.dostawa.servicerouteoptimization.domain.models.gateways.RouteRepository;
import co.com.dostawa.servicerouteoptimization.domain.usecase.RouteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteCaseConfig {
    @Bean
    public RouteUseCase routeUseCase(RouteRepository routeRepository) {
        return new RouteUseCase(routeRepository);
    }
}
