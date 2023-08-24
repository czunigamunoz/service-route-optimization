package co.com.dostawa.servicerouteoptimization.infraestructure.mapper;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document.OrderDocument;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toOrder(OrderDocument orderDocument){
        return new Order(
                orderDocument.getOrderId(),
                orderDocument.getCreatedAt(),
                orderDocument.getDeliveries(),
                orderDocument.getVehicles()
        );
    }

    public OrderDocument toOrderDocument(Order order){
        return new OrderDocument(
                order.getOrderId(),
                order.getCreatedAt(),
                order.getDeliveries(),
                order.getVehicles()
        );
    }
}
