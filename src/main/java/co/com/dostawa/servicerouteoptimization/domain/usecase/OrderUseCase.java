package co.com.dostawa.servicerouteoptimization.domain.usecase;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OptimizationGateway;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OrderRepository;
import co.com.dostawa.servicerouteoptimization.domain.usecase.helper.DateFormatter;
import co.com.dostawa.servicerouteoptimization.domain.usecase.helper.LimitValidation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderUseCase {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final OrderRepository orderRepository;
    private final OptimizationGateway optimizationGateway;

    /**
     * Save new order
     *
     * @param order Order object
     * @return Order object created
     */
    public Order createOrder(Order order) {
        try {
            order.setCreatedAt(DateFormatter.format());
            ResponseEntity<HttpStatus> resp = optimizationGateway.createOrderOptimization(order);
            if (resp.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error optimizing order");
            }
            return orderRepository.create(order);
        } catch (Exception e) {
            throw new RuntimeException("Error creating order");
        }
    }

    /**
     * Get order by id
     * @param id String
     * @return Order object
     */
    public Optional<Order> getOrder(String id) {
        try {
            return orderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting route");
        }
    }

    /**
     * Returns orders by date
     * @param dateStr String date in format String
     * @return List of orders
     */
    public List<Order> getOrdersByDate(String dateStr, int limit) {
        try {
            int limitDefault = LimitValidation.getLimit(limit);
            return orderRepository.findOrdersByDate(dateStr, limitDefault);
        } catch (Exception e) {
            throw new RuntimeException("Error getting routes");
        }
    }
}
