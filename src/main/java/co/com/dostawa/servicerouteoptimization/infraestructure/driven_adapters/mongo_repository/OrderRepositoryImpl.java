package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OrderRepository;
import co.com.dostawa.servicerouteoptimization.infraestructure.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderMapper orderMapper;
    private final OrderMongoRepository orderRepository;
    /**
     * Represents instance of Mongo template for criteria
     */
    private final MongoTemplate mongoTemplate;

    @Override
    public Order create(Order order) {
        return orderMapper.toOrder(orderRepository.save(orderMapper.toOrderDocument(order)));
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(id).map(orderMapper::toOrder);
    }

    @Override
    public List<Order> findOrdersByDate(String date, int limit) {
        return orderRepository.findByCreatedAt(date);
       /* return mongoTemplate.find(Query.query(Criteria.where("createdAt").is(date)).limit(limit), Order.class);*/
    }
}
