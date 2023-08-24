package co.com.dostawa.servicerouteoptimization.domain.models.gateways;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    /**
     * Save new order
     *
     * @param order Order object
     * @return Order object
     */
    Order create(Order order);
    /**
     * Get order by id
     * @param id String
     * @return Order object
     */
    Optional<Order> findById(String id);
    /**
     * Returns orders by date
     * @param dateStr String date in format String
     * @return List of orders
     */
    List<Order> findOrdersByDate(String dateStr, int limit);
}
