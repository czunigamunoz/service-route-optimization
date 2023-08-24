package co.com.dostawa.servicerouteoptimization.domain.models.gateways;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface OptimizationGateway {

    /**
     * Get order optimization
     *
     * @param order Order to optimize
     * @return ResponseEntity
     */
    ResponseEntity<HttpStatus> createOrderOptimization(Order order) throws IOException;
}
